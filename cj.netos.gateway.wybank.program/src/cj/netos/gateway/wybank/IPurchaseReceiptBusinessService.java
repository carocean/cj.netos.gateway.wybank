package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import com.rabbitmq.client.LongString;

import java.math.BigDecimal;

public interface IPurchaseReceiptBusinessService {
    PurchaseRecord purchase(String purchaser,String purchaserName, String wenyBankID, long amount,String out_trade_sn, String note) throws CircuitException;

    PurchaseRecord getPurchaseRecord(String purchaseSN);

    void ackSuccess(String record_sn, BigDecimal stock, BigDecimal price);

    void ackFailure(String record_sn, String state, String message);

    void flagExchanging(String sn);

    void ackExchangedSuccess(String refPurchase);

    void ackExchangedFailure(String refPurchase);

}
