package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.studio.ecm.net.CircuitException;

public interface IExchangeReceiptBusinessService {
    ExchangeRecord exchange(PurchaseRecord purchaseRecord, String note) throws CircuitException;

}
