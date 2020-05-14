package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;

public class PurchaseBO {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: purchaser
     * Remark: 申购人
     */
    private String purchaser;

    /**
     * Column: person_name
     * Remark: 申购者的显示名
     */
    private String personName;

    /**
     * Column: currency
     */
    private String currency;

    /**
     * Column: amount
     * Remark: 申购金
     */
    private Long amount;


    /**
     * Column: ttm
     * Remark: 申购时给的市盈率
     */
    private BigDecimal ttm;

    /**
     * Column: ptime
     * Remark: 申购时间
     */
    private String ptime;

    /**
     * Column: state
     * Remark: 0申购中 1成功 2失败
     */
    private Integer state;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    /**
     * Column: service_fee
     * Remark: 服务费
     */
    private Long serviceFee;

    /**
     * Column: principal_amount
     * Remark: 拆分：本金金额
     */
    private Long principalAmount;

    /**
     * Column: fee_ratio
     * Remark: 服务费率
     */
    private BigDecimal feeRatio;

    /**
     * Column: principal_ratio
     */
    private BigDecimal principalRatio;

    /**
     * Column: tail_amount
     * Remark: 尾金
     */
    private Long tailAmount;


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

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getTtm() {
        return ttm;
    }

    public void setTtm(BigDecimal ttm) {
        this.ttm = ttm;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
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

    public Long getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Long serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Long getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public BigDecimal getFeeRatio() {
        return feeRatio;
    }

    public void setFeeRatio(BigDecimal feeRatio) {
        this.feeRatio = feeRatio;
    }

    public BigDecimal getPrincipalRatio() {
        return principalRatio;
    }

    public void setPrincipalRatio(BigDecimal principalRatio) {
        this.principalRatio = principalRatio;
    }

    public Long getTailAmount() {
        return tailAmount;
    }

    public void setTailAmount(Long tailAmount) {
        this.tailAmount = tailAmount;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
}
