package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IPersonService;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.IWithdrawReceiptBusinessService;
import cj.netos.gateway.wybank.mapper.WithdrawRecordMapper;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "withdrawReceiptBusinessService")
public class WithdrawReceiptBusinessService implements IWithdrawReceiptBusinessService {
    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.WithdrawRecordMapper")
    WithdrawRecordMapper withdrawRecordMapper;

    @CjServiceRef
    IPersonService personService;

    @CjServiceRef
    IWenyBankService wenyBankService;

    @CjTransaction
    @Override
    public WithdrawRecord withdraw(ISecuritySession securitySession, String wenyBankID, String shunter, long req_amount, String note) throws CircuitException {
        Map<String, Object> person = (Map<String, Object>) personService.getPersonInfo((String) securitySession.property("accessToken"));
        if (person == null) {
            throw new CircuitException("404", String.format("用户不存在:" + securitySession.principal()));
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(wenyBankID);
        if (bankInfo == null) {
            throw new CircuitException("404", String.format("纹银银行不存在:%s", wenyBankID));
        }

        WithdrawRecord record = new WithdrawRecord();
        record.setBankid(wenyBankID);
        record.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        record.setDtime(record.getCtime());
        record.setNote(note);
        record.setPersonName((String) person.get("nickName"));
        record.setRealAmount(0L);
        record.setReqAmount(req_amount);
        record.setShunter(shunter);
        record.setSn(IdWorker.nextId());
        record.setState(0);
        record.setWithdrawer((String) person.get("person"));

        withdrawRecordMapper.insert(record);
        return record;
    }

    @CjTransaction
    @Override
    public WithdrawRecord getRecord(String sn) {
        return withdrawRecordMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public void ackSuccess(String sn, Long realAmount) {
        withdrawRecordMapper.ackSuccess(sn, realAmount,BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }

    @CjTransaction
    @Override
    public void ackFailure(String sn, String status, String message) {
        withdrawRecordMapper.ackFailure(sn, status, message,BankUtils.dateTimeToSecond(System.currentTimeMillis()));
    }
}
