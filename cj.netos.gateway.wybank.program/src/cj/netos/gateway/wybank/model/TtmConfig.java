package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;

/**
 * Table: ttm_config
 */
public class TtmConfig {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: bankid
     */
    private String bankid;

    /**
     * Column: ttm
     * Remark: 市盈率
     */
    private BigDecimal ttm;

    /**
     * Column: min_amount
     * Remark: 市盈率所在区间的下边界金额
     */
    private Long minAmount;

    /**
     * Column: max_amount
     * Remark: 上边界金额
     */
    private Long maxAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public BigDecimal getTtm() {
        return ttm;
    }

    public void setTtm(BigDecimal ttm) {
        this.ttm = ttm;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }
}