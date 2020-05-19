package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.PriceBill;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/bill/price.ports")
public class PriceBillPorts implements IPriceBillPorts {
    @Override
    public List<PriceBill> pagePriceBill(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
        return null;
    }

    @Override
    public List<PriceBill> getPriceBillOfMonth(ISecuritySession securitySession, String wenyBankID, int month) throws CircuitException {
        return null;
    }

    @Override
    public List<PriceBill> getPriceBillOfCurrentDay(ISecuritySession securitySession, String wenyBankID, int month, int day) throws CircuitException {
        return null;
    }

    @Override
    public List<PriceBill> getPriceBillOfCurrentWeek(ISecuritySession securitySession, String wenyBankID) throws CircuitException {
        return null;
    }
}
