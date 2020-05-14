package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IPersonService;
import cj.netos.gateway.wybank.IReceiptBusinessService;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.mapper.PurchaseRecordMapper;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.TtmConfig;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "receiptBusinessService")
public class ReceiptBusinessService implements IReceiptBusinessService {
    @CjServiceRef
    IPersonService personService;

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.PurchaseRecordMapper")
    PurchaseRecordMapper purchaseRecordMapper;

    @CjServiceSite
    IServiceSite site;

    @CjTransaction
    @Override
    public PurchaseRecord purchase(ISecuritySession securitySession, String wenyBankID, long amount, String note) throws CircuitException {
        Map<String, Object> person = (Map<String, Object>) personService.getPersonInfo((String) securitySession.property("accessToken"));
        if (person == null) {
            throw new CircuitException("404", String.format("用户不存在:" + securitySession.principal()));
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(wenyBankID);
        if (bankInfo == null) {
            throw new CircuitException("404", String.format("纹银银行不存在:" + wenyBankID));
        }
        PurchaseRecord record = new PurchaseRecord();
        try {
            record.setSn(new IdWorker(3).nextId() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        record.setAmount(amount);
        record.setBankid(wenyBankID);
        record.setCurrency("CNY");
        record.setNote(note);
        record.setReserveRatio(bankInfo.getReserveRatio());
        record.setFreeRatio(bankInfo.getFreeRatio());
        record.setFeeRatio(bankInfo.getFreeRatio().add(bankInfo.getReserveRatio()));
        record.setPrincipalRatio(bankInfo.getPrincipalRatio());
        record.setPersonName((String) person.get("nickName"));
        record.setPurchaser(securitySession.principal());
        long service_fee = record.getFeeRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setServiceFee(service_fee);
        long principal = record.getPrincipalRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setPrincipalAmount(principal);
        long freeAmount = record.getFreeRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setFreeAmount(freeAmount);
        long reserveAmount = record.getReserveRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setReserveAmount(reserveAmount);
        long tailAmount = amount  - principal-freeAmount-reserveAmount;
        record.setTailAmount(tailAmount);

        record.setState(0);
        record.setPtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        List<TtmConfig> ttms = wenyBankService.getTTMTable(wenyBankID);
        String default_ttm = site.getProperty("default.ttm");
        BigDecimal ttm = new BigDecimal(default_ttm);
        for (TtmConfig config : ttms) {
            if (amount >= config.getMinAmount() && amount < config.getMaxAmount()) {
                ttm = config.getTtm();
                break;
            }
        }
        record.setTtm(ttm);


        purchaseRecordMapper.insert(record);
        return record;
    }
}
