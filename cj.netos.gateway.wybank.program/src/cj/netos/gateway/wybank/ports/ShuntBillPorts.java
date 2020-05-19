package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ShunterBill;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;
@CjService(name = "/bill/shunt.ports")
public class ShuntBillPorts implements IShuntBillPorts {
    @Override
    public List<ShunterBill> pageBill(ISecuritySession securitySession, String wenyBankID, String shunter, int limit, long offset) throws CircuitException {
        return null;
    }

    @Override
    public List<ShunterBill> getBillOfMonth(ISecuritySession securitySession, String wenyBankID, String shunter, int month) throws CircuitException {
        return null;
    }

    @Override
    public long totalInBillOfMonth(ISecuritySession securitySession, String wenyBankID, String shunter, int month) throws CircuitException {
        return 0;
    }

    @Override
    public long totalInBillOfCurrentWeek(ISecuritySession securitySession, String wenyBankID, String shunter, int yeer) throws CircuitException {
        return 0;
    }

    @Override
    public long totalOutBillOfMonth(ISecuritySession securitySession, String wenyBankID, String shunter, int month) throws CircuitException {
        return 0;
    }

    @Override
    public long totalOutBillOfCurrentWeek(ISecuritySession securitySession, String wenyBankID, String shunter, int yeer) throws CircuitException {
        return 0;
    }
}
