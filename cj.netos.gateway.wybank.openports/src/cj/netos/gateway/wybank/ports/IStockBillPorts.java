package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.FundBill;
import cj.netos.gateway.wybank.bo.StockBill;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.math.BigDecimal;
import java.util.List;

@CjOpenports(usage = "纹银出入账单")
public interface IStockBillPorts extends IOpenportService {
    @CjOpenport(usage = "分页账单")
    List<StockBill> pageBill(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                             @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                             @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单")
    List<StockBill> getBillOfMonth(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                   @CjOpenportParameter(usage = "年份", name = "year") int year,
                                   @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                   @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                   @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单入账总量")
    BigDecimal totalInBillOfMonth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取当年账单入账总量")
    BigDecimal totalInBillOfYear(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "年份", name = "year") int year
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单出账总金额")
    BigDecimal totalOutBillOfMonth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取当周账单出账总量")
    BigDecimal totalOutBillOfYear(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "年份", name = "year") int year
    ) throws CircuitException;
}
