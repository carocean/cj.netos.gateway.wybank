package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.*;
import cj.netos.gateway.wybank.bo.ExchangeBO;
import cj.netos.gateway.wybank.bo.PurchaseBO;
import cj.netos.gateway.wybank.bo.ShuntRecordBO;
import cj.netos.gateway.wybank.bo.WithdrawBO;
import cj.netos.gateway.wybank.model.*;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/trade/receipt.ports")
public class ReceiptBusinessPorts implements IReceiptBusinessPorts {
    @CjServiceRef(refByName = "@.rabbitmq.producer.trade")
    IRabbitMQProducer rabbitMQ;

    @CjServiceRef
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;

    @CjServiceRef
    IExchangeReceiptBusinessService exchangeReceiptBusinessService;

    @CjServiceRef
    IWithdrawReceiptBusinessService withdrawReceiptBusinessService;

    @CjServiceRef
    IShuntReceiptBusinessService shuntReceiptBusinessService;

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjServiceRef
    IPersonService personService;

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
            throw new CircuitException("501", String.format("申购单未完成，或已承兑。purchaseSN=%s", purchaseRecord.getSn()));
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

    @Override
    public WithdrawBO withdraw(ISecuritySession securitySession, String wenyBankID, String shunter, long req_amount, String note) throws CircuitException {
        if (StringUtil.isEmpty(wenyBankID)) {
            throw new CircuitException("404", "行号为空");
        }
        if (StringUtil.isEmpty(shunter)) {
            throw new CircuitException("404", "分账器为空");
        }
        if (req_amount < 0) {
            throw new CircuitException("500", "请求金额为负数");
        }
        List<String> persons = wenyBankService.getWithdrawRights(wenyBankID, shunter);
        if (!persons.contains(securitySession.principal())) {
            throw new CircuitException("800", "无提现权限。用户:" + securitySession.principal());
        }

        WithdrawRecord record = withdrawReceiptBusinessService.withdraw(securitySession, wenyBankID, shunter, req_amount, note);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "withdraw");
                        put("withdrawer", record.getWithdrawer());
                        put("withdrawerName", record.getPersonName());
                        put("appid", (String) securitySession.property("appid"));
                        put("wenyBankID", wenyBankID);
                        put("shunter", shunter);
                        put("record_sn", record.getSn());
                    }
                }).build();
        byte[] body = new Gson().toJson(record).getBytes();
        rabbitMQ.publish(properties, body);

        WithdrawBO bo = new WithdrawBO();
        bo.load(record);
        return bo;
    }

    @Override
    public ShuntRecordBO shunt(ISecuritySession securitySession, String wenyBankID, long req_amount, String note) throws CircuitException {
        if (StringUtil.isEmpty(wenyBankID)) {
            throw new CircuitException("404", "行号为空");
        }

        if (req_amount < 0) {
            throw new CircuitException("500", "请求金额为负数");
        }
        Map<String, Object> person = (Map<String, Object>) personService.getPersonInfo((String) securitySession.property("accessToken"));
        if (person == null) {
            throw new CircuitException("404", String.format("用户不存在:" + securitySession.principal()));
        }

        BankInfo bankInfo = wenyBankService.getWenyBank(wenyBankID);
        if (bankInfo == null) {
            throw new CircuitException("404", String.format("纹银银行不存在:%s", wenyBankID));
        }
        if (!securitySession.roleIn("platform:administrators") && !securitySession.principal().equals(bankInfo.getOwner())) {
            throw new CircuitException("800", "拒绝访问");
        }
        List<Shunter> shunters = wenyBankService.getShunters(wenyBankID);

        ShuntRecord record = shuntReceiptBusinessService.shunt((String) person.get("person"), (String) person.get("nickName"), wenyBankID, shunters, req_amount, note);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wybank.ports")
                .headers(new HashMap() {
                    {
                        put("command", "shunt");
                        put("operator", record.getOperator());
                        put("operatorName", record.getPersonName());
                        put("appid", (String) securitySession.property("appid"));
                        put("wenyBankID", wenyBankID);
                        put("record_sn", record.getSn());
                    }
                }).build();
        byte[] body = new Gson().toJson(record).getBytes();
        rabbitMQ.publish(properties, body);

        ShuntRecordBO bo = new ShuntRecordBO();
        bo.load(record);
        return bo;
    }
}
