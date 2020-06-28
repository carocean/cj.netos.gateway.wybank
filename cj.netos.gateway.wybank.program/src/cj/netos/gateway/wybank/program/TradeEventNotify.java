package cj.netos.gateway.wybank.program;

import cj.netos.gateway.wybank.ITradeEventNotify;
import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;

@CjService(name = "tradeEventNotify")
public class TradeEventNotify implements ITradeEventNotify {
    @CjServiceRef(refByName = "@.rabbitmq.producer.notify")
    IRabbitMQProducer rabbitMQProducer;

    @Override
    public void sendToWallet(String command, String status, String message, Object content) {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank/trade/settle.mq")
                .headers(new HashMap<String, Object>() {{
                    put("command", command);
                    put("status", status);
                    put("message", message);
                }}).build();
        try {
            rabbitMQProducer.publish("wallet", properties, new Gson().toJson(content).getBytes());
        } catch (CircuitException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Override
    public void sendToAbsorbRobot(String command, String status, String message, Object content) {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank/trade/settle.mq")
                .headers(new HashMap<String, Object>() {{
                    put("command", command);
                    put("status", status);
                    put("message", message);
                }}).build();
        try {
            rabbitMQProducer.publish("absorbRobot", properties, new Gson().toJson(content).getBytes());
        } catch (CircuitException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
