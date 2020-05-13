package cj.netos.gateway.wybank.ports;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.math.BigDecimal;
import java.util.Map;

@CjOpenports(usage = "纹银银行开放服务")
public interface IWenyBankTradePorts extends IOpenportService {

    @CjOpenport(usage = "申购")
    void purchase(ISecuritySession securitySession,
                                 @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                                 @CjOpenportParameter(usage = "申购金额", name = "amount") long amount,
                                 @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "承兑。承兑只能按申购单整笔承兑。")
    void exchange(ISecuritySession securitySession,
                                 @CjOpenportParameter(usage = "原申购单号", name = "purchaseSN") String purchaseSN,
                                 @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

}
