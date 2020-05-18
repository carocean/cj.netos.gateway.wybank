package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ExchangeBO;
import cj.netos.gateway.wybank.bo.PurchaseBO;
import cj.netos.gateway.wybank.bo.WithdrawBO;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "收单业务开放服务")
public interface IReceiptBusinessPorts extends IOpenportService {

    @CjOpenport(usage = "申购")
    PurchaseBO purchase(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                        @CjOpenportParameter(usage = "申购金额", name = "amount") long amount,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "承兑。承兑只能按申购单整笔承兑。")
    ExchangeBO exchange(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "原申购单号", name = "purchaseSN") String purchaseSN,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "提现")
    WithdrawBO withdraw(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                        @CjOpenportParameter(usage = "要提现的分账器", name = "shunter") String shunter,
                        @CjOpenportParameter(usage = "请求的提现金额，实际提多可能小于等于请求金", name = "req_amount") long req_amount,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;
}
