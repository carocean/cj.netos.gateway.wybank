package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IRecordService;
import cj.netos.gateway.wybank.bo.ShuntRecordResult;
import cj.netos.gateway.wybank.mapper.*;
import cj.netos.gateway.wybank.model.*;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "recordService")
public class RecordService implements IRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ExchangeRecordMapper")
    ExchangeRecordMapper exchangeRecordMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.PurchaseRecordMapper")
    PurchaseRecordMapper purchaseRecordMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.WithdrawRecordMapper")
    WithdrawRecordMapper withdrawRecordMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShuntRecordMapper")
    ShuntRecordMapper shuntRecordMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShuntDetailsMapper")
    ShuntDetailsMapper shuntDetailsMapper;

    @CjTransaction
    @Override
    public List<ExchangeRecord> pageExchangeRecord(String wenyBankID, int limit, long offset) {
        return exchangeRecordMapper.page(wenyBankID, limit, offset);
    }

    @CjTransaction
    @Override
    public ExchangeRecord getExchangeRecord(String record_sn) {
        return exchangeRecordMapper.selectByPrimaryKey(record_sn);
    }

    @CjTransaction
    @Override
    public List<PurchaseRecord> pagePurchaseRecord(String wenyBankID, int limit, long offset) {
        return purchaseRecordMapper.page(wenyBankID, limit, offset);
    }
    @CjTransaction
    @Override
    public List<PurchaseRecord> pagePurchaseRecordByState(String wenyBankID, String beginDayText, String endDayText, int state, int limit, long offset) {
        return purchaseRecordMapper.pageInMonth(wenyBankID,beginDayText,endDayText,state, limit, offset);
    }
    @CjTransaction
    @Override
    public List<PurchaseRecord> pageExchangeRecordByState(String wenyBankID, String beginDayText, String endDayText, int state, int limit, long offset) {
        return exchangeRecordMapper.pageInMonth(wenyBankID,beginDayText,endDayText,state, limit, offset);
    }

    @CjTransaction
    @Override
    public PurchaseRecord getPurchaseRecord(String record_sn) {
        return purchaseRecordMapper.selectByPrimaryKey(record_sn);
    }

    @CjTransaction
    @Override
    public List<WithdrawRecord> pageWithdrawRecord(String wenyBankID, int limit, long offset) {
        return withdrawRecordMapper.page(wenyBankID, limit, offset);
    }

    @CjTransaction
    @Override
    public WithdrawRecord getWithdrawRecord(String record_sn) {
        return withdrawRecordMapper.selectByPrimaryKey(record_sn);
    }

    @CjTransaction
    @Override
    public List<ShuntRecordResult> pageShuntRecord(String wenyBankID, int limit, long offset) {
        List<ShuntRecord> records = shuntRecordMapper.page(wenyBankID, limit, offset);
        List<ShuntRecordResult> list = new ArrayList<>();
        for (ShuntRecord record : records) {
            ShuntDetailsExample example = new ShuntDetailsExample();
            example.createCriteria().andShuntSnEqualTo(record.getSn());
            List<ShuntDetails> details = shuntDetailsMapper.selectByExample(example);
            ShuntRecordResult result = new Gson().fromJson(new Gson().toJson(record), ShuntRecordResult.class);
            result.setDetails(details);
            list.add(result);
        }
        return list;
    }

    @CjTransaction
    @Override
    public ShuntRecordResult getShuntRecord(String record_sn) throws CircuitException {
        ShuntRecord record = shuntRecordMapper.selectByPrimaryKey(record_sn);
        if (record == null) {
            return null;
        }
        ShuntDetailsExample example = new ShuntDetailsExample();
        example.createCriteria().andShuntSnEqualTo(record_sn);
        List<ShuntDetails> details = shuntDetailsMapper.selectByExample(example);
        ShuntRecordResult result = new Gson().fromJson(new Gson().toJson(record), ShuntRecordResult.class);
        result.setDetails(details);
        return result;
    }
}
