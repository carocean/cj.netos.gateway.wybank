package cj.netos.gateway.wybank.ports;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "纹银银行开放服务")
public interface IWYBankPorts extends IOpenportService {

    @CjOpenport(usage = "申购，必须购买服务才有纹银的申购权")
    void purchase(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "承兑，按当前价格将指定纹银兑换成法币")
    void exchange(ISecuritySession securitySession) throws CircuitException;
}
