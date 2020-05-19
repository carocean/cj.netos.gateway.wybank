package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IShuntReceiptBusinessService;
import cj.netos.gateway.wybank.mapper.ShuntDetailsMapper;
import cj.netos.gateway.wybank.mapper.ShuntRecordMapper;
import cj.netos.gateway.wybank.model.ShuntDetails;
import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "shuntReceiptBusinessService")
public class ShuntReceiptBusinessService implements IShuntReceiptBusinessService {
    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShuntRecordMapper")
    ShuntRecordMapper shuntRecordMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShuntDetailsMapper")
    ShuntDetailsMapper shuntDetailsMapper;
    @CjTransaction
    @Override
    public ShuntRecord shunt(String operator,String personName, String wenyBankID, List<Shunter> shunters, long req_amount, String note) throws CircuitException {

        ShuntRecord record = new ShuntRecord();
        record.setBankid(wenyBankID);
        record.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        record.setDtime(record.getCtime());
        record.setNote(note);
        record.setPersonName(personName);
        record.setRealAmount(0L);
        record.setReqAmount(req_amount);
        record.setOperator(operator);
        record.setSn(IdWorker.nextId());
        record.setState(0);
        record.setSource(0);
        record.setShunters(new Gson().toJson(shunters));

        shuntRecordMapper.insert(record);
        return record;
    }

    @CjTransaction
    @Override
    public void ackSuccess(String sn, Long realAmount, Integer source, List<ShuntDetails> details) {
        for (ShuntDetails shuntDetails : details) {
            shuntDetailsMapper.insert(shuntDetails);
        }
        shuntRecordMapper.ackSuccess(sn, realAmount,source, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackFailure(String sn, String status, String message, Integer source) {
        shuntRecordMapper.ackFailure(sn, status, message,source, BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public ShuntRecord getRecord(String sn) {
        return shuntRecordMapper.selectByPrimaryKey(sn);
    }
}
