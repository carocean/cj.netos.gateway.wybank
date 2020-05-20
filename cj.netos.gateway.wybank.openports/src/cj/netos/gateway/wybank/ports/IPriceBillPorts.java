package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.PriceBill;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "历史价格")
public interface IPriceBillPorts extends IOpenportService {
    @CjOpenport(usage = "分页价格单，按最新排序")
    List<PriceBill> pagePriceBill(ISecuritySession securitySession,
                                  @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                  @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                  @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "按月获取价格单")
    List<PriceBill> getPriceBillOfMonth(ISecuritySession securitySession,
                                        @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                        @CjOpenportParameter(usage = "年", name = "year") int year,
                                        @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                        @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                        @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "按日获取价格单")
    List<PriceBill> getPriceBillOfDay(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                                      @CjOpenportParameter(usage = "年", name = "year") int year,
                                      @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                      @CjOpenportParameter(usage = "日", name = "day") int day,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

}
