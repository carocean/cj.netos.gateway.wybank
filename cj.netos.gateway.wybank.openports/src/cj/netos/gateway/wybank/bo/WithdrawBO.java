package cj.netos.gateway.wybank.bo;


import cj.netos.gateway.wybank.model.WithdrawRecord;

public class WithdrawBO extends WithdrawRecord {

    public void load(WithdrawRecord record) {
        setBankid(record.getBankid());
        setCtime(record.getCtime());
        setDtime(record.getDtime());
        setMessage(record.getMessage());
        setNote(record.getNote());
        setPersonName(record.getPersonName());
        setRealAmount(record.getRealAmount());
        setReqAmount(record.getReqAmount());
        setShunter(record.getShunter());
        setSn(record.getSn());
        setState(record.getState());
        setStatus(record.getStatus());
        setWithdrawer(record.getWithdrawer());
    }
}
