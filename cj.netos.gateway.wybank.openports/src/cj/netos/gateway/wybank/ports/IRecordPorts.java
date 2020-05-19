package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "明细流水账服务")
public interface IRecordPorts extends IOpenportService {
    @CjOpenport(usage = "分页承兑单")
    List<ExchangeRecord> pageExchangeRecord(ISecuritySession securitySession,
                                            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "获取承兑单")
    ExchangeRecord getExchangeRecord(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "订单号", name = "record_sn") String record_sn
    ) throws CircuitException;

    @CjOpenport(usage = "分页申购单")
    List<PurchaseRecord> pagePurchaseRecord(ISecuritySession securitySession,
                                            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "获取申购单")
    PurchaseRecord getPurchaseRecord(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "订单号", name = "record_sn") String record_sn
    ) throws CircuitException;

    @CjOpenport(usage = "分页提现单")
    List<WithdrawRecord> pageWithdrawRecord(ISecuritySession securitySession,
                                            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "获取提现单")
    WithdrawRecord getWithdrawRecord(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "订单号", name = "record_sn") String record_sn
    ) throws CircuitException;

    @CjOpenport(usage = "分页分账单")
    List<ShuntRecord> pageShuntRecord(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                      @CjOpenportParameter(usage = "分账类别", name = "shunter") String shunter
    ) throws CircuitException;

    @CjOpenport(usage = "获取分账单")
    ShuntRecord getShuntRecord(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "订单号", name = "record_sn") String record_sn
    ) throws CircuitException;
}
