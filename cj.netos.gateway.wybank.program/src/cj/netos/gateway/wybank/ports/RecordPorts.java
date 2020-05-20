package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IRecordService;
import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.ShuntRecordBO;
import cj.netos.gateway.wybank.bo.ShuntRecordResult;
import cj.netos.gateway.wybank.model.*;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/record.ports")
public class RecordPorts implements IRecordPorts {

    @CjServiceRef
    IRecordService recordService;

    @CjServiceRef
    IWenyBankService wenyBankService;


    BankInfo demandBankOwner(ISecuritySession securitySession, String bankid) throws CircuitException {
        BankInfo bankInfo = wenyBankService.getWenyBank(bankid);
        if (bankInfo == null) {
            throw new CircuitException("404", "纹银银行不存在:" + bankid);
        }
        if (!securitySession.roleIn("platform:administrators") && !securitySession.principal().equals(bankInfo.getOwner())) {
            throw new CircuitException("800", String.format("拒绝访问。行号=%s", bankid));
        }
        return bankInfo;
    }

    @Override
    public List<ExchangeRecord> pageExchangeRecord(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);
        return recordService.pageExchangeRecord(wenyBankID, limit, offset);
    }

    @Override
    public ExchangeRecord getExchangeRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        ExchangeRecord record = recordService.getExchangeRecord(record_sn);
        if (record == null) {
            return null;
        }
        demandBankOwner(securitySession, record.getBankid());
        return record;
    }

    @Override
    public List<PurchaseRecord> pagePurchaseRecord(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);
        return recordService.pagePurchaseRecord(wenyBankID, limit, offset);
    }

    @Override
    public PurchaseRecord getPurchaseRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        PurchaseRecord record = recordService.getPurchaseRecord(record_sn);
        if (record == null) {
            return null;
        }
        demandBankOwner(securitySession, record.getBankid());
        return record;
    }

    @Override
    public List<WithdrawRecord> pageWithdrawRecord(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);
        return recordService.pageWithdrawRecord(wenyBankID, limit, offset);
    }

    @Override
    public WithdrawRecord getWithdrawRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        WithdrawRecord record = recordService.getWithdrawRecord(record_sn);
        if (record == null) {
            return null;
        }
        demandBankOwner(securitySession, record.getBankid());
        return record;
    }

    @Override
    public List<ShuntRecordResult> pageShuntRecord(ISecuritySession securitySession, String wenyBankID, String shunter, int limit, long offset) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);
        return recordService.pageShuntRecord(wenyBankID, limit, offset);
    }

    @Override
    public ShuntRecordResult getShuntRecord(ISecuritySession securitySession, String record_sn) throws CircuitException {
        ShuntRecordResult record = recordService.getShuntRecord(record_sn);
        if (record == null) {
            return null;
        }
        demandBankOwner(securitySession, record.getBankid());
        return record;
    }
}
