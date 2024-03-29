package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ShunterBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.Incubator;
import cj.netos.gateway.wybank.model.IncubatorEvents;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "纹银银行")
public interface IWenyBankPorts extends IOpenportService {

    @CjOpenport(usage = "创建一个纹银银行", command = "post")
    BankInfo createWenyBank(ISecuritySession securitySession,
                            @CjOpenportParameter(usage = "纹银银行配置", name = "wenyBankBO", in = PKeyInRequest.content, simpleModelFile = "/WenyBankBO.html") WenyBankBO wenyBankBO
    ) throws CircuitException;

    @CjOpenport(usage = "放入一个纹银银行进入孵化器并开启")
    void putBankOnIncubator(ISecuritySession securitySession,
                            @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "放入一个纹银银行进入孵化器并开启")
    void stopBankOnIncubator(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "放入一个纹银银行进入孵化器并开启")
    void restartBankOnIncubator(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "放入一个纹银银行进入孵化器并开启")
    void removeBankOnIncubator(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "列出孵化器中的银行")
    List<Incubator> listBankOnIncubator(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "列表孵化器中的银行事件")
    List<IncubatorEvents> listBankEventsOnIncubator(ISecuritySession securitySession,
                                                    @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "分页查询")
    List<BankInfo> pageWenyBank(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "偏移", name = "offset") int offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页查询")
    List<BankInfo> pageWenyBankByCreators(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "创建者集合", name = "creators") List<String> creators,
            @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") int offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页查询")
    List<BankInfo> pageWenyBankByLicences(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "营业执照集合", name = "licences") List<String> licences,
            @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") int offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页查询")
    List<BankInfo> pageWenyBankByDistricts(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "营业区域代码集合", name = "districts") List<String> districts,
            @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
            @CjOpenportParameter(usage = "偏移", name = "offset") int offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行")
    BankInfo getWenyBank(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行")
    List<BankInfo> getMyWenyBank(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行")
    BankInfo getWenyBankByDistrict(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "经营区域代码", name = "district") String district
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行，如果不存在则创建")
    BankInfo getAndAutoCreateWenyBankByDistrict(ISecuritySession securitySession,
                                                @CjOpenportParameter(usage = "经营区域代码", name = "district") String district
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行")
    BankInfo getWenyBankByLicence(ISecuritySession securitySession,
                                  @CjOpenportParameter(usage = "营业执照", name = "licence") String licence
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个银行的概要信息")
    BankInfo getWenyBankInfo(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "停止运营")
    void stopWenyBank(ISecuritySession securitySession,
                      @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;


    @CjOpenport(usage = "强制本地用户使用当地纹银银行，一般是孵化完下沉后")
    void forceUseWenyBank(ISecuritySession securitySession,
                      @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "解除强制本地用户使用当地纹银银行")
    void unforceUseWenyBank(ISecuritySession securitySession,
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


    @CjOpenport(usage = "设置一套分账器", command = "post")
    void setShunters(ISecuritySession securitySession,
                     @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                     @CjOpenportParameter(usage = "分账器，比率必须加起来等1", name = "shunters", elementType = ShunterBO.class, in = PKeyInRequest.content, simpleModelFile = "/ShunterRuleBO.html") List<ShunterBO> shunters
    ) throws CircuitException;


    @CjOpenport(usage = "清空分账器")
    void emptyShunters(ISecuritySession securitySession,
                       @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn
    ) throws CircuitException;

    @CjOpenport(usage = "获取分账器")
    List<ShunterBO> getShunters(ISecuritySession securitySession,
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

    @CjOpenport(usage = "添加提现权限")
    void addWithdrawRights(ISecuritySession securitySession,
                           @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                           @CjOpenportParameter(usage = "目标分账器", name = "shunter") String shunter,
                           @CjOpenportParameter(usage = "具有权限的所有用户，以;号隔开", name = "persons") String persons
    ) throws CircuitException;

    @CjOpenport(usage = "清空提现权限")
    void emptyWithdrawRights(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                             @CjOpenportParameter(usage = "目标分账器", name = "shunter") String shunter
    ) throws CircuitException;

    @CjOpenport(usage = "获取提现权限。返回person集合")
    List<String> getWithdrawRights(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "纹银银行行号", name = "banksn") String banksn,
                                   @CjOpenportParameter(usage = "目标分账器", name = "shunter") String shunter

    ) throws CircuitException;
}
