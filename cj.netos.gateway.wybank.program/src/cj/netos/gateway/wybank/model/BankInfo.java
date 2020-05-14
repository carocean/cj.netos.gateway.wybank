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
     * Remark: 行显示名
     */
    private String title;

    /**
     * Column: owner
     * Remark: 归属人，person格式
     */
    private String owner;

    /**
     * Column: property
     * Remark: 归属人性质：0.个人；1.企业
     */
    private Integer property;

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
     * Column: creator
     * Remark: 创建者
     */
    private String creator;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}