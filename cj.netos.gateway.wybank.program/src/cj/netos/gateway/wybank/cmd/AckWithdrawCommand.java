package cj.netos.gateway.wybank.cmd;

import cj.netos.gateway.wybank.IShuntReceiptBusinessService;
import cj.netos.gateway.wybank.IWithdrawReceiptBusinessService;
import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.WithdrawRecord;
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
@CjService(name = "/wybank.ports#ackWithdraw")
public class AckWithdrawCommand implements IConsumerCommand {
    @CjServiceRef
    IWithdrawReceiptBusinessService withdrawReceiptBusinessService;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
        LongString state = (LongString) properties.getHeaders().get("state");
        LongString message = (LongString) properties.getHeaders().get("message");
        LongString record_sn = (LongString) properties.getHeaders().get("record_sn");
        WithdrawRecord record = withdrawReceiptBusinessService.getRecord(record_sn.toString());
        WithdrawRecord response = new Gson().fromJson(new String(body), WithdrawRecord.class);
        if ("200".equals(state.toString())) {
            record.setState(1);
            record.setRealAmount(response.getRealAmount());
            withdrawReceiptBusinessService.ackSuccess(record_sn.toString(), response.getRealAmount());
            return;
        }
        String msg = message == null ? "" : message.toString();
        if (msg.length() > 254) {
            msg = msg.substring(0, 200);
        }
        withdrawReceiptBusinessService.ackFailure(record_sn.toString(), state.toString(), msg);
    }
}
