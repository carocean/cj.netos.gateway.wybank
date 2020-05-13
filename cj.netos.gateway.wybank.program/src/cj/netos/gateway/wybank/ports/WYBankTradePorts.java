package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IPersonService;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.Map;

@CjService(name = "/trade.ports")
public class WYBankTradePorts implements IWenyBankTradePorts {
    @CjServiceRef(refByName = "rabbitMQProducer")
    IRabbitMQProducer rabbitMQ;
    @CjServiceRef
    IPersonService personService;
    @Override
    public void purchase(ISecuritySession securitySession, String wenyBankID, long amount, String note) throws CircuitException {
        if (StringUtil.isEmpty(wenyBankID)) {
            throw new CircuitException("404", "行号为空");
        }
        if (amount < 0) {
            throw new CircuitException("500", "金额为负数");
        }
        Map<String, Object> person = (Map<String, Object>) personService.getPersonInfo((String) securitySession.property("accessToken"));
        if (person == null) {
            throw new CircuitException("404", String.format("用户不存在:" + securitySession.principal()));
        }
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "purchase");
                        put("device", securitySession.property("device"));
                        put("person", securitySession.principal());
                        put("nickName",person.get("nickName"));
                        put("appid", (String) securitySession.property("appid"));
                        put("wenyBankID", wenyBankID);
                        put("amount", amount);
                        put("note", note);
                    }
                }).build();
//        byte[] body = new Gson().toJson(rechargeBO).getBytes();
        rabbitMQ.publish(properties, new byte[0]);
    }

    @Override
    public void exchange(ISecuritySession securitySession, String purchaseSN, String note) throws CircuitException {
        if (StringUtil.isEmpty(purchaseSN)) {
            throw new CircuitException("404", "申购单号为空");
        }
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "exchange");
                        put("device", securitySession.property("device"));
                        put("person", securitySession.principal());
                        put("appid", (String) securitySession.property("appid"));
                        put("purchaseSN", purchaseSN);
                        put("note", note);
                    }
                }).build();
//        byte[] body = new Gson().toJson(rechargeBO).getBytes();
        rabbitMQ.publish(properties, new byte[0]);
    }
}
