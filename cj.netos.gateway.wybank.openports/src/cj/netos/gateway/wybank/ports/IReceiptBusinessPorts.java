package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ExchangeBO;
import cj.netos.gateway.wybank.bo.PurchaseBO;
import cj.netos.gateway.wybank.bo.ShuntRecordBO;
import cj.netos.gateway.wybank.bo.WithdrawBO;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "收单业务开放服务")
public interface IReceiptBusinessPorts extends IOpenportService {

    @CjOpenportAppSecurity
    @CjOpenport(usage = "申购", tokenIn = AccessTokenIn.nope)
    PurchaseBO purchase(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                        @CjOpenportParameter(usage = "申购人", name = "purchaser") String purchaser,
                        @CjOpenportParameter(usage = "申购人姓名", name = "purchaserName") String purchaserName,
                        @CjOpenportParameter(usage = "申购金额", name = "amount") long amount,
                        @CjOpenportParameter(usage = "外部系统交易订单号", name = "out_trade_sn") String out_trade_sn,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenportAppSecurity
    @CjOpenport(usage = "承兑。承兑只能按申购单整笔承兑。", tokenIn = AccessTokenIn.nope)
    ExchangeBO exchange(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "原申购单号", name = "purchaseSN") String purchaseSN,
                        @CjOpenportParameter(usage = "外部系统交易订单号", name = "out_trade_sn") String out_trade_sn,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenportAppSecurity
    @CjOpenport(usage = "向分账器余额提现", tokenIn = AccessTokenIn.nope)
    WithdrawBO withdraw(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                        @CjOpenportParameter(usage = "要提现的分账器", name = "shunter") String shunter,
                        @CjOpenportParameter(usage = "提现人", name = "withdrawer") String withdrawer,
                        @CjOpenportParameter(usage = "提现人姓名", name = "withdrawerName") String withdrawerName,
                        @CjOpenportParameter(usage = "请求的提现金额，实际提多可能小于等于请求金", name = "req_amount") long req_amount,
                        @CjOpenportParameter(usage = "外部系统交易订单号", name = "out_trade_sn") String out_trade_sn,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenportAppSecurity
    @CjOpenport(usage = "触发分账。从自由金余额中分账给各分账器", tokenIn = AccessTokenIn.nope)
    ShuntRecordBO shunt(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "wenyBankID") String wenyBankID,
                        @CjOpenportParameter(usage = "操作人", name = "operator") String operator,
                        @CjOpenportParameter(usage = "操作人姓名", name = "operatorName") String operatorName,
                        @CjOpenportParameter(usage = "请求的分账金额，根据自由金额实际可能小于等于请求金", name = "req_amount") long req_amount,
                        @CjOpenportParameter(usage = "外部系统交易订单号", name = "out_trade_sn") String out_trade_sn,
                        @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;
}
