package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IPersonService;
import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
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
import com.rabbitmq.client.LongString;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "purchaseReceiptBusinessService")
public class PurchaseReceiptBusinessService implements IPurchaseReceiptBusinessService {

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.PurchaseRecordMapper")
    PurchaseRecordMapper purchaseRecordMapper;

    @CjServiceSite
    IServiceSite site;

    @CjTransaction
    @Override
    public PurchaseRecord purchase(String purchaser,String purchaserName, String wenyBankID, long amount,String out_trade_sn, String note) throws CircuitException {
        if (purchaser == null) {
            throw new CircuitException("404", String.format("用户不存在:" + purchaser));
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(wenyBankID);
        if (bankInfo == null) {
            throw new CircuitException("404", String.format("纹银银行不存在:%s", wenyBankID));
        }
        PurchaseRecord record = new PurchaseRecord();
        record.setSn(IdWorker.nextId());
        record.setOutTradeSn(out_trade_sn);
        record.setAmount(amount);
        record.setBankid(wenyBankID);
        record.setCurrency("CNY");
        record.setNote(note);
        record.setReserveRatio(bankInfo.getReserveRatio());
        record.setFreeRatio(bankInfo.getFreeRatio());
        record.setFeeRatio(bankInfo.getFreeRatio().add(bankInfo.getReserveRatio()));
        record.setPrincipalRatio(bankInfo.getPrincipalRatio());
        record.setPersonName(purchaserName);
        record.setPurchaser(purchaser);
//        record.setDevice((String) securitySession.property("device"));
        long service_fee = record.getFeeRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setServiceFee(service_fee);
        long principal = record.getPrincipalRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setPrincipalAmount(principal);
        long freeAmount = record.getFreeRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setFreeAmount(freeAmount);
        long reserveAmount = record.getReserveRatio().multiply(new BigDecimal(amount)).setScale(14, BigDecimal.ROUND_DOWN).longValue();
        record.setReserveAmount(reserveAmount);
        long tailAmount = amount - principal - freeAmount - reserveAmount;
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

    @CjTransaction
    @Override
    public PurchaseRecord getPurchaseRecord(String purchaseSN) {
        return purchaseRecordMapper.selectByPrimaryKey(purchaseSN);
    }

    @CjTransaction
    @Override
    public void ackSuccess(String record_sn, BigDecimal stock, BigDecimal price) {
        purchaseRecordMapper.ackSuccess(record_sn, stock, price, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackFailure(String record_sn, String status, String message) {
        purchaseRecordMapper.ackFailure(record_sn, status, message, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void flagExchanging(String record_sn) {
        purchaseRecordMapper.updateState(record_sn, 2,BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackExchangedSuccess(String record_sn) {
        purchaseRecordMapper.updateState(record_sn, 3,BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackExchangedFailure(String record_sn) {
        purchaseRecordMapper.ackExchangedFailure(record_sn,"600","承兑失败",BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }
}
