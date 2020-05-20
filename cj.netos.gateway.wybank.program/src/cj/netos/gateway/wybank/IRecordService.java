package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.bo.ShuntRecordResult;
import cj.netos.gateway.wybank.model.*;
import cj.studio.ecm.net.CircuitException;

import java.util.List;

public interface IRecordService {
    List<ExchangeRecord> pageExchangeRecord(String wenyBankID, int limit, long offset);

    ExchangeRecord getExchangeRecord(String record_sn);

    List<PurchaseRecord> pagePurchaseRecord(String wenyBankID, int limit, long offset);

    PurchaseRecord getPurchaseRecord(String record_sn);

    List<WithdrawRecord> pageWithdrawRecord(String wenyBankID, int limit, long offset);

    WithdrawRecord getWithdrawRecord(String record_sn);

    List<ShuntRecordResult> pageShuntRecord(String wenyBankID, int limit, long offset);

    ShuntRecordResult getShuntRecord(String record_sn) throws CircuitException;

}
