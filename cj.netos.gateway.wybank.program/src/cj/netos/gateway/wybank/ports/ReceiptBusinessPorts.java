package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IExchangeReceiptBusinessService;
import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
import cj.netos.gateway.wybank.bo.ExchangeBO;
import cj.netos.gateway.wybank.bo.PurchaseBO;
import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.util.IdWorker;
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
    @CjServiceRef(refByName = "@.rabbitmq.producer.trade")
    IRabbitMQProducer rabbitMQ;

    @CjServiceRef
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;
    @CjServiceRef
    IExchangeReceiptBusinessService exchangeReceiptBusinessService;

    @Override
    public PurchaseBO purchase(ISecuritySession securitySession, String wenyBankID, long amount, String note) throws CircuitException {
        if (StringUtil.isEmpty(wenyBankID)) {
            throw new CircuitException("404", "行号为空");
        }
        if (amount < 0) {
            throw new CircuitException("500", "金额为负数");
        }

        PurchaseRecord record = purchaseReceiptBusinessService.purchase(securitySession, wenyBankID, amount, note);

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
    public ExchangeBO exchange(ISecuritySession securitySession, String purchaseSN, String note) throws CircuitException {
        if (StringUtil.isEmpty(purchaseSN)) {
            throw new CircuitException("404", "申购单号为空");
        }
        PurchaseRecord purchaseRecord = purchaseReceiptBusinessService.getPurchaseRecord(purchaseSN);
        if (purchaseRecord == null) {
            throw new CircuitException("404", "申购单不存在");
        }
        if (!purchaseRecord.getPurchaser().equals(securitySession.principal())) {
            throw new CircuitException("500", String.format("不是申购者本人:%s!=%s", securitySession.principal(), purchaseRecord.getPurchaser()));
        }
        if (purchaseRecord.getState() != 1) {
            throw new CircuitException("501", String.format("申购单未完成，不能承兑。purchaseSN=%s", purchaseRecord.getSn()));
        }
        ExchangeRecord exchangeRecord = exchangeReceiptBusinessService.exchange(purchaseRecord, note);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "exchange");
                        put("exchanger", exchangeRecord.getExchanger());
                        put("exchangerName", exchangeRecord.getPersonName());
                        put("appid", (String) securitySession.property("appid"));
                        put("wenyBankID", exchangeRecord.getBankid());
                        put("record_sn", exchangeRecord.getSn());
                    }
                }).build();
        byte[] body = new Gson().toJson(exchangeRecord).getBytes();
        rabbitMQ.publish(properties, body);

        ExchangeBO bo = new ExchangeBO();
        bo.setBankid(exchangeRecord.getBankid());
        bo.setCtime(exchangeRecord.getCtime());
        bo.setCurrency(exchangeRecord.getCurrency());
        bo.setExchanger(exchangeRecord.getExchanger());
        bo.setNote(exchangeRecord.getNote());
        bo.setPersonName(exchangeRecord.getPersonName());
        bo.setPrincipalAmount(exchangeRecord.getPrincipalAmount());
        bo.setPurchaseAmount(exchangeRecord.getPurchaseAmount());
        bo.setRefPurchase(exchangeRecord.getRefPurchase());
        bo.setServiceFeeAmount(exchangeRecord.getServiceFeeamount());
        bo.setSn(exchangeRecord.getSn());
        bo.setState(exchangeRecord.getState());
        bo.setStock(exchangeRecord.getStock());
        bo.setTtm(exchangeRecord.getTtm());
        return bo;

    }
}
