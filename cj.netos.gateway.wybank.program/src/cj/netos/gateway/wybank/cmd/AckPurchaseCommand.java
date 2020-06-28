package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
import cj.netos.gateway.wybank.IShuntReceiptBusinessService;
import cj.netos.gateway.wybank.ITradeEventNotify;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.LongString;

import java.util.HashMap;
import java.util.List;

@CjConsumer(name = "ack")
@CjService(name = "/wybank.ports#ackPurchase")
public class AckPurchaseCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "purchaseReceiptBusinessService")
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;
    @CjServiceRef(refByName = "@.rabbitmq.producer.trade")
    IRabbitMQProducer rabbitMQ;

    @CjServiceRef
    IShuntReceiptBusinessService shuntReceiptBusinessService;

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjServiceRef
    ITradeEventNotify tradeEventNotify;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
        LongString state = (LongString) properties.getHeaders().get("state");
        LongString message = (LongString) properties.getHeaders().get("message");
        LongString record_sn = (LongString) properties.getHeaders().get("record_sn");
        PurchaseRecord record = purchaseReceiptBusinessService.getPurchaseRecord(record_sn.toString());
        if ("200".equals(state.toString())) {
            PurchaseRecord response = new Gson().fromJson(new String(body), PurchaseRecord.class);
            record.setState(1);
            record.setStock(response.getStock());
            record.setPrice(response.getPrice());
            purchaseReceiptBusinessService.ackSuccess(record_sn.toString(), response.getStock(), response.getPrice());
            tradeEventNotify.sendToWallet("purchase", response.getStatus(), response.getMessage(),response);
            //触发分账
            try {
                onshunt(record);
            } catch (CircuitException e) {
                CJSystem.logging().warn(getClass(), e);
            }
            return;
        }
        String msg = message == null ? "" : message.toString();
        if (msg.length() > 254) {
            msg = msg.substring(0, 200);
        }
        purchaseReceiptBusinessService.ackFailure(record_sn.toString(), state.toString(), msg);
        tradeEventNotify.sendToWallet("purchase", state.toString(),msg,record);
    }

    private void onshunt(PurchaseRecord purchaseRecord) throws CircuitException {
        List<Shunter> shunters = wenyBankService.getShunters(purchaseRecord.getBankid());

        ShuntRecord record = shuntReceiptBusinessService.shunt(purchaseRecord.getPurchaser(), purchaseRecord.getPersonName(), purchaseRecord.getBankid(), shunters, purchaseRecord.getFreeAmount(), purchaseRecord.getOutTradeSn(), "自由分账");
        record.setSource(1);
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "shunt");
                        put("operator", record.getOperator());
                        put("operatorName", record.getPersonName());
                        put("wenyBankID", purchaseRecord.getBankid());
                        put("record_sn", record.getSn());
                    }
                }).build();
        byte[] body = new Gson().toJson(record).getBytes();
        rabbitMQ.publish("shunt",properties, body);
    }
}
