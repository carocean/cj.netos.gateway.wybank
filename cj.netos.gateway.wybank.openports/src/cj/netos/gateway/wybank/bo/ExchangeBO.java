package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;

public class ExchangeBO {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: exchanger
     * Remark: 承兑人
     */
    private String exchanger;

    /**
     * Column: person_name
     * Remark: 用户显示名
     */
    private String personName;

    /**
     * Column: currency
     */
    private String currency;

    /**
     * Column: purchaseAmount
     * Remark: 原申购金
     */
    private Long purchaseAmount;

    /**
     * Column: principalAmount
     * Remark: 原申购本金
     */
    private Long principalAmount;

    /**
     * Column: serviceFeeAmount
     * Remark: 原申购收取的服务费
     */
    private Long serviceFeeAmount;
    /**
     * Column: stock
     * Remark: 申购单中的纹银量，即要承况的量
     */
    private BigDecimal stock;

    /**
     * Column: ttm
     * Remark: 结算市盈率
     */
    private BigDecimal ttm;

    /**
     * Column: ref_purchase
     * Remark: 关联申购单号
     */
    private String refPurchase;


    /**
     * Column: ctime
     * Remark: 生成承兑单时间
     */
    private String ctime;

    /**
     * Column: state
     * Remark: 0承兑中 1完成 2失败
     */
    private Integer state;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    /**
     * Column: bankid
     */
    private String bankid;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getExchanger() {
        return exchanger;
    }

    public void setExchanger(String exchanger) {
        this.exchanger = exchanger;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Long getServiceFeeAmount() {
        return serviceFeeAmount;
    }

    public void setServiceFeeAmount(Long serviceFeeAmount) {
        this.serviceFeeAmount = serviceFeeAmount;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getTtm() {
        return ttm;
    }

    public void setTtm(BigDecimal ttm) {
        this.ttm = ttm;
    }

    public String getRefPurchase() {
        return refPurchase;
    }

    public void setRefPurchase(String refPurchase) {
        this.refPurchase = refPurchase;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
}
