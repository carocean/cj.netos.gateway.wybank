package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/record.ports")
public class RecordPorts implements IRecordPorts {
    @Override
    public List<ExchangeRecord> pageExchangeRecord(ISecuritySession securitySession, String wenyBankID) throws CircuitException {
        return null;
    }

    @Override
    public ExchangeRecord getExchangeRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        return null;
    }

    @Override
    public List<PurchaseRecord> pagePurchaseRecord(ISecuritySession securitySession, String wenyBankID) throws CircuitException {
        return null;
    }

    @Override
    public PurchaseRecord getPurchaseRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        return null;
    }

    @Override
    public List<WithdrawRecord> pageWithdrawRecord(ISecuritySession securitySession, String wenyBankID) throws CircuitException {
        return null;
    }

    @Override
    public WithdrawRecord getWithdrawRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        return null;
    }

    @Override
    public List<ShuntRecord> pageShuntRecord(ISecuritySession securitySession, String wenyBankID, String shunter) throws CircuitException {
        return null;
    }

    @Override
    public ShuntRecord getShuntRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        return null;
    }
}
