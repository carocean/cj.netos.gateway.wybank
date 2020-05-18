package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.Shunter;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IShuntReceiptBusinessService {
    ShuntRecord shunt(String operator,String personName, String wenyBankID, List<Shunter> shunters, long req_amount, String note) throws CircuitException;

    void ackSuccess(String toString, Long realAmount, Integer source);

    void ackFailure(String toString, String toString1, String msg, Integer source);

    ShuntRecord getRecord(String toString);

}
