package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ShunterRuleBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.AccessTokenIn;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportAppSecurity;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;
import java.util.Map;

@CjOpenports(usage = "纹银银行")
public interface IWenyBankPorts extends IOpenportService {

    @CjOpenport(usage = "创建一个纹银银行", command = "post")
    Map<String, Object> createWenyBank(ISecuritySession securitySession,
                                       @CjOpenportParameter(usage = "纹银银行配置", name = "wenyBankBO", in = PKeyInRequest.content, simpleModelFile = "/WenyBankBO.html") WenyBankBO wenyBankBO
    ) throws CircuitException;

    @CjOpenport(usage = "分页查询")
    List<Map<String, Object>> pageWenyBank(ISecuritySession securitySession,
                                           @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                           @CjOpenportParameter(usage = "偏移", name = "offset") int offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行")
    Map<String, Object> getWenyBank(ISecuritySession securitySession,
                                    @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "停止运营")
    void stopWenyBank(ISecuritySession securitySession,
                      @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;


    @CjOpenport(usage = "运营")
    void startWenyBank(ISecuritySession securitySession,
                       @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;


    @CjOpenport(usage = "注销一个纹银银行")
    void cancelWenyBank(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;


    @CjOpenport(usage = "设置一套分账规则", command = "post")
    void setShunterRules(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                         @CjOpenportParameter(usage = "分账规则，比率必须加起来等1", name = "rules", elementType = ShunterRuleBO.class, in = PKeyInRequest.content, simpleModelFile = "/ShunterRuleBO.html") List<ShunterRuleBO> rules
    ) throws CircuitException;


    @CjOpenport(usage = "清空分账规则")
    void emptyShunterRules(ISecuritySession securitySession,
                           @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "获取分账规则")
    List<ShunterRuleBO> getShunterRules(ISecuritySession securitySession,
                                        @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "设置一套市盈率", command = "post")
    void setTTMTable(ISecuritySession securitySession,
                     @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                     @CjOpenportParameter(usage = "分账规则，比率必须加起来等1", name = "ttmTable", elementType = TTMBO.class, in = PKeyInRequest.content, simpleModelFile = "/TTMBO.html") List<TTMBO> ttmTable
    ) throws CircuitException;


    @CjOpenport(usage = "清空市盈率")
    void emptyTTMTable(ISecuritySession securitySession,
                       @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "获取市盈率配置")
    List<TTMBO> getTTMTable(ISecuritySession securitySession,
                            @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;
}
