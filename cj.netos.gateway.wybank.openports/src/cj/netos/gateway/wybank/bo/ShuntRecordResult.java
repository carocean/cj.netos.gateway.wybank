package cj.netos.gateway.wybank.bo;

import cj.netos.gateway.wybank.model.ShuntDetails;
import cj.netos.gateway.wybank.model.ShuntRecord;

import java.util.List;

public class ShuntRecordResult extends ShuntRecord {
    List<ShuntDetails> details;

    public List<ShuntDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ShuntDetails> details) {
        this.details = details;
    }

}
