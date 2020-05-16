package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.LongString;

@CjConsumer(name = "ack")
@CjService(name = "/wybank.ports#ackPurchase")
public class AckPurchaseCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "purchaseReceiptBusinessService")
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;

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
            return;
        }
        String msg = message == null ? "" : message.toString();
        if (msg.length() > 254) {
            msg = msg.substring(0, 200);
        }
        purchaseReceiptBusinessService.ackFailure(record_sn.toString(), state.toString(), msg);
    }
}
