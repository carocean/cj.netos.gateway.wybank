package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

public interface IPurchaseReceiptBusinessService {
    PurchaseRecord purchase(ISecuritySession securitySession, String wenyBankID, long amount, String note) throws CircuitException;

    PurchaseRecord getPurchaseRecord(String purchaseSN);

}
