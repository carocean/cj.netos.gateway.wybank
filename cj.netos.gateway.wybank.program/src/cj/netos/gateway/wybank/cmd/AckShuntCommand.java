package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IShuntReceiptBusinessService;
import cj.netos.gateway.wybank.model.ShuntRecord;
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

@CjConsumer(name = "ack")
@CjService(name = "/wybank.ports#ackShunt")
public class AckShuntCommand implements IConsumerCommand {
    @CjServiceRef
    IShuntReceiptBusinessService shuntReceiptBusinessService;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
        LongString state = (LongString) properties.getHeaders().get("state");
        LongString message = (LongString) properties.getHeaders().get("message");
        LongString record_sn = (LongString) properties.getHeaders().get("record_sn");
        ShuntRecord record = shuntReceiptBusinessService.getRecord(record_sn.toString());
        ShuntRecord response = new Gson().fromJson(new String(body), ShuntRecord.class);
        if ("200".equals(state.toString())) {
            record.setState(1);
            record.setRealAmount(response.getRealAmount());
            shuntReceiptBusinessService.ackSuccess(record_sn.toString(), response.getRealAmount(),response.getSource());
            return;
        }
        String msg = message == null ? "" : message.toString();
        if (msg.length() > 254) {
            msg = msg.substring(0, 200);
        }
        shuntReceiptBusinessService.ackFailure(record_sn.toString(), state.toString(), msg,response.getSource());
    }
}
