package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IExchangeReceiptBusinessService;
import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
import cj.netos.gateway.wybank.ITradeEventNotify;
import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.LongString;

@CjConsumer(name = "fromOC_ack_exchange")
@CjService(name = "/wybank.ports#ackExchange")
public class AckExchangeCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "exchangeReceiptBusinessService")
    IExchangeReceiptBusinessService exchangeReceiptBusinessService;
    @CjServiceRef
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;
    @CjServiceRef
    ITradeEventNotify tradeEventNotify;
    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
        LongString state = (LongString) properties.getHeaders().get("state");
        LongString message = (LongString) properties.getHeaders().get("message");
        LongString record_sn = (LongString) properties.getHeaders().get("record_sn");
        ExchangeRecord record = exchangeReceiptBusinessService.getExchangeRecord(record_sn.toString());
        if ("200".equals(state.toString())) {
            ExchangeRecord response = new Gson().fromJson(new String(body), ExchangeRecord.class);
            record.setState(1);
            record.setStock(response.getStock());
            record.setPrice(response.getPrice());
            exchangeReceiptBusinessService.ackSuccess(record_sn.toString(), response.getAmount(), response.getProfit(), response.getPrice());
            purchaseReceiptBusinessService.ackExchangedSuccess(record.getRefPurchase());
            tradeEventNotify.sendToWallet("exchange", response.getStatus(), response.getMessage(),response);
            return;
        }
        String msg = message == null ? "" : message.toString();
        if (msg.length() > 254) {
            msg = msg.substring(0, 200);
        }
        exchangeReceiptBusinessService.ackFailure(record_sn.toString(), state.toString(), msg);
        if (record != null) {
            purchaseReceiptBusinessService.ackExchangedFailure(record.getRefPurchase());
        }
        tradeEventNotify.sendToWallet("exchange", state.toString(),msg,record);
    }
}
