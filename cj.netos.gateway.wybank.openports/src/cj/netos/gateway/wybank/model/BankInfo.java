package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;

/**
 * Table: bank_info
 */
public class BankInfo {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: title
     * Remark: 行显示名，一般为地商或运营商的简称
     */
    private String title;

    /**
     * Column: ctime
     * Remark: 创建时间
     */
    private String ctime;

    /**
     * Column: location
     * Remark: 地理位置
     */
    private String location;

    /**
     * Column: state
     * Remark: 0- 正常运营 1- 停止营业 2- 已注销
     */
    private Integer state;

    /**
     * Column: principal_ratio
     * Remark: 本金比例
     */
    private BigDecimal principalRatio;

    /**
     * Column: reserve_ratio
     * Remark: 准备金比例
     */
    private BigDecimal reserveRatio;

    /**
     * Column: free_ratio
     * Remark: 自由金比例
     */
    private BigDecimal freeRatio;

    /**
     * Column: licence
     * Remark: 纹银银行是以什么执照营业的？LA或ISP营业执照的标识
     */
    private String licence;

    /**
     * Column: creator
     * Remark: 申请人的公号
     */
    private String creator;

    /**
     * Column: icon
     * Remark: 纹银银行logo
     */
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPrincipalRatio() {
        return principalRatio;
    }

    public void setPrincipalRatio(BigDecimal principalRatio) {
        this.principalRatio = principalRatio;
    }

    public BigDecimal getReserveRatio() {
        return reserveRatio;
    }

    public void setReserveRatio(BigDecimal reserveRatio) {
        this.reserveRatio = reserveRatio;
    }

    public BigDecimal getFreeRatio() {
        return freeRatio;
    }

    public void setFreeRatio(BigDecimal freeRatio) {
        this.freeRatio = freeRatio;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence == null ? null : licence.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}