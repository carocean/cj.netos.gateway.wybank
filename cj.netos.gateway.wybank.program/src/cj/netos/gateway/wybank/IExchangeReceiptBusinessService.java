package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.studio.ecm.net.CircuitException;

import java.math.BigDecimal;

public interface IExchangeReceiptBusinessService {
    ExchangeRecord exchange(PurchaseRecord purchaseRecord,String out_trade_sn, String note) throws CircuitException;

    ExchangeRecord getExchangeRecord(String sn);

    void ackSuccess(String sn, long amount,long profit, BigDecimal price);

    void ackFailure(String sn, String status, String message);

}
