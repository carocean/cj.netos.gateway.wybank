package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

public interface IWithdrawReceiptBusinessService {
    WithdrawRecord withdraw(ISecuritySession securitySession, String wenyBankID, String shunter, long req_amount, String note) throws CircuitException;

}
