package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

public interface IWithdrawReceiptBusinessService {
    WithdrawRecord withdraw(String withdrawer,String withdrawerName, String wenyBankID, String shunter, long req_amount,String out_trade_sn, String note) throws CircuitException;

    WithdrawRecord getRecord(String sn);

    void ackSuccess(String toString, Long realAmount);

    void ackFailure(String toString, String toString1, String msg);

}
