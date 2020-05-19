package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;
import java.util.Map;

@CjOpenports(usage = "余额类服务")
public interface IBucketPorts extends IOpenportService {
    @CjOpenport(usage = "当前价格")
    PriceResult getPriceBucket(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行当前价格")
    List<PriceResult> pagePriceBucket(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前资金余额")
    FundResult getFundBucket(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行资金余额")
    List<FundResult> pageFundBucket(ISecuritySession securitySession,
                                    @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                    @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前冻结资金余额")
    FreezenResult getFreezenBucket(ISecuritySession securitySession,
                                   @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行冻结资金余额")
    List<FreezenResult> pageFreezenBucket(ISecuritySession securitySession,
                                          @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                          @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前自由资金余额")
    FreeResult getFreeBucket(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行自由资金余额")
    List<FreeResult> pageFreeBucket(ISecuritySession securitySession,
                                    @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                    @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前纹银存量余额")
    StockResult getStockBucket(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行纹银存量余额")
    List<StockResult> pageStockBucket(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前纹银银行分账类余额")
    List<ShuntResult> getAllShuntBucket(ISecuritySession securitySession,
                                        @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;

    @CjOpenport(usage = "分页各银行分账类余额")
    List<ShuntResult> pageShuntBucket(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "当前分账类余额")
    ShuntResult getShuntBucket(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID,
                               @CjOpenportParameter(usage = "分账类别", name = "shunter") String shunter
    ) throws CircuitException;

    @CjOpenport(usage = "获取一个纹银银行的所有余额类，除了分账类余额")
    Map<String, Object> getAllBucketOfBank(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "纹银银行号", name = "wenyBankID") String wenyBankID
    ) throws CircuitException;
}
