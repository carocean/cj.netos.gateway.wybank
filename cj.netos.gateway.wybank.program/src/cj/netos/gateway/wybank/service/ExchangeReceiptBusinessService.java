package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IExchangeReceiptBusinessService;
import cj.netos.gateway.wybank.IPersonService;
import cj.netos.gateway.wybank.IPurchaseReceiptBusinessService;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.mapper.ExchangeRecordMapper;
import cj.netos.gateway.wybank.mapper.PurchaseRecordMapper;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.math.BigDecimal;

@CjBridge(aspects = "@transaction")
@CjService(name = "exchangeReceiptBusinessService")
public class ExchangeReceiptBusinessService implements IExchangeReceiptBusinessService {
    @CjServiceRef
    IPersonService personService;

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ExchangeRecordMapper")
    ExchangeRecordMapper exchangeRecordMapper;

    @CjServiceRef
    IPurchaseReceiptBusinessService purchaseReceiptBusinessService;

    @CjTransaction
    @Override
    public ExchangeRecord exchange(PurchaseRecord purchaseRecord, String note) throws CircuitException {

        ExchangeRecord record = new ExchangeRecord();
        record.setBankid(purchaseRecord.getBankid());
        record.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        record.setCurrency("WENY");
        record.setExchanger(purchaseRecord.getPurchaser());
        record.setPersonName(purchaseRecord.getPersonName());
        record.setNote(note);
        record.setPrincipalAmount(purchaseRecord.getPrincipalAmount());
        record.setPurchaseAmount(purchaseRecord.getAmount());
        record.setPurchasePrice(purchaseRecord.getPrice());
        record.setRefPurchase(purchaseRecord.getSn());
        record.setServiceFeeamount(purchaseRecord.getServiceFee());
        record.setSn(IdWorker.nextId());
        record.setState(0);
        record.setStock(purchaseRecord.getStock());
        record.setTtm(purchaseRecord.getTtm());

        exchangeRecordMapper.insert(record);
        purchaseReceiptBusinessService.flagExchanging(purchaseRecord.getSn());
        return record;
    }

    @CjTransaction
    @Override
    public ExchangeRecord getExchangeRecord(String sn) {
        return exchangeRecordMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public void ackSuccess(String sn, long amount, long profit, BigDecimal price) {
        exchangeRecordMapper.ackSuccess(sn, amount, profit, price, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackFailure(String sn, String status, String message) {
        exchangeRecordMapper.ackFailure(sn, status, message, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }
}
