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

    /**
     * Column: master_id
     * Remark: 业主的标识，关联运营商或地商标识
     */
    private String masterId;

    /**
     * Column: master_type
     * Remark: 0为地商； 1为市商（该标记永不用，留给将来市商兼容地商业务用） 2为运营商；
     */
    private Integer masterType;

    /**
     * Column: master_person
     * Remark: 业主所有权人，格式是公号，为yong yu字段，对应地商或运营商的业主字段
     */
    private String masterPerson;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public Integer getMasterType() {
        return masterType;
    }

    public void setMasterType(Integer masterType) {
        this.masterType = masterType;
    }

    public String getMasterPerson() {
        return masterPerson;
    }

    public void setMasterPerson(String masterPerson) {
        this.masterPerson = masterPerson == null ? null : masterPerson.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}