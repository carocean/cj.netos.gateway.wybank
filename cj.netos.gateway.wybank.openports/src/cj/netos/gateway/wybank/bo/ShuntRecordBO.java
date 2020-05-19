package cj.netos.gateway.wybank.bo;

import cj.netos.gateway.wybank.model.ShuntRecord;

public class ShuntRecordBO extends ShuntRecord {
    public void load(ShuntRecord record) {
        setBankid(record.getBankid());
        setCtime(record.getCtime());
        setDtime(record.getDtime());
        setMessage(record.getMessage());
        setNote(record.getNote());
        setOperator(record.getOperator());
        setPersonName(record.getPersonName());
        setRealAmount(record.getRealAmount());
        setReqAmount(record.getReqAmount());
        setShunters(record.getShunters());
        setSn(record.getSn());
        setSource(record.getSource());
        setState(record.getState());
        setStatus(record.getStatus());
    }

}
