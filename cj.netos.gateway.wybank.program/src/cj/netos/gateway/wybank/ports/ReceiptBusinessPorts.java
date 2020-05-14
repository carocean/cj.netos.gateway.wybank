package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IReceiptBusinessService;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.PurchaseBO;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;

@CjService(name = "/trade/receipt.ports")
public class ReceiptBusinessPorts implements IReceiptBusinessPorts {
    @CjServiceRef(refByName = "rabbitMQProducer")
    IRabbitMQProducer rabbitMQ;

    @CjServiceRef
    IReceiptBusinessService receiptBusinessService;

    @Override
    public PurchaseBO purchase(ISecuritySession securitySession, String wenyBankID, long amount, String note) throws CircuitException {
        if (StringUtil.isEmpty(wenyBankID)) {
            throw new CircuitException("404", "行号为空");
        }
        if (amount < 0) {
            throw new CircuitException("500", "金额为负数");
        }

        PurchaseRecord record = receiptBusinessService.purchase(securitySession, wenyBankID, amount, note);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "purchase");
                        put("purchaser", record.getPurchaser());
                        put("purchaserName", record.getPersonName());
                        put("appid", (String) securitySession.property("appid"));
                        put("wenyBankID", wenyBankID);
                        put("record_sn", record.getSn());
                    }
                }).build();
        byte[] body = new Gson().toJson(record).getBytes();
        rabbitMQ.publish(properties, body);

        PurchaseBO bo = new PurchaseBO();
        bo.setAmount(record.getAmount());
        bo.setBankid(record.getBankid());
        bo.setCurrency(record.getCurrency());
        bo.setFeeRatio(record.getFeeRatio());
        bo.setNote(record.getNote());
        bo.setPersonName(record.getPersonName());
        bo.setPrincipalAmount(record.getPrincipalAmount());
        bo.setPrincipalRatio(record.getPrincipalRatio());
        bo.setPtime(record.getPtime());
        bo.setPurchaser(record.getPurchaser());
        bo.setSn(record.getSn());
        bo.setState(record.getState());
        bo.setServiceFee(record.getServiceFee());
        bo.setTailAmount(record.getTailAmount());
        bo.setTtm(record.getTtm());
        return bo;
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
