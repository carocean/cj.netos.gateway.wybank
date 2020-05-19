package cj.netos.gateway.wybank.bo;



import cj.netos.gateway.wybank.model.ShuntDetails;
import cj.netos.gateway.wybank.model.ShuntRecord;

import java.util.List;

public class ShuntResponse {
    String operator;
    String operatorName;
    String wenyBankID;
    String status;
    String message;
    String record_sn;
    ShuntRecord record;
    List<ShuntDetails> details;
    public String getRecord_sn() {
        return record_sn;
    }

    public void setRecord_sn(String record_sn) {
        this.record_sn = record_sn;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getWenyBankID() {
        return wenyBankID;
    }

    public void setWenyBankID(String wenyBankID) {
        this.wenyBankID = wenyBankID;
    }

    public ShuntRecord getRecord() {
        return record;
    }

    public void setRecord(ShuntRecord record) {
        this.record = record;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ShuntDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ShuntDetails> details) {
        this.details = details;
    }
}
