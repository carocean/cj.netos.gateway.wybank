package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.FreeBill;
import cj.netos.gateway.wybank.bo.FreezenBill;
import cj.netos.gateway.wybank.bo.ShunterBill;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "分账金出入账单")
public interface IShuntBillPorts extends IOpenportService {
    @CjOpenport(usage = "分页账单")
    List<ShunterBill> pageBill(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                               @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
                               @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                               @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单")
    List<ShunterBill> getBillOfMonth(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                     @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
                                     @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单入账总金额")
    long totalInBillOfMonth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取当周账单入账总金额")
    long totalInBillOfCurrentWeek(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
            @CjOpenportParameter(usage = "年份", name = "yeer") int yeer
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单出账总金额")
    long totalOutBillOfMonth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取当周账单出账总金额")
    long totalOutBillOfCurrentWeek(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
            @CjOpenportParameter(usage = "分账类别名", name = "shunter") String shunter,
            @CjOpenportParameter(usage = "年份", name = "yeer") int yeer
    ) throws CircuitException;

}
