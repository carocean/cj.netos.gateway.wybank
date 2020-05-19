package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;

/**
 * Table: stock_bill
 */
public class StockBill {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: title
     * Remark: 显示名，一般是人名
     */
    private String title;

    /**
     * Column: participant
     * Remark: 参与者：申购人、承兑人
     */
    private String participant;

    /**
     * Column: bankid
     */
    private String bankid;

    /**
     * Column: order
     * Remark: 指令：0申购、1承兑
     */
    private Integer order;

    /**
     * Column: stock
     * Remark: 申购或承兑的发生额
     */
    private BigDecimal stock;

    /**
     * Column: balance
     * Remark: 变化后的纹银现量余额
     */
    private BigDecimal balance;

    /**
     * Column: refsn
     * Remark: 关联申购或承兑
     */
    private String refsn;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: note
     */
    private String note;

    /**
     * Column: workday
     * Remark: 会计日期
     */
    private String workday;

    /**
     * Column: day
     * Remark: 天，1-31
     */
    private Integer day;

    /**
     * Column: month
     * Remark: 月
     */
    private Integer month;

    /**
     * Column: weekday
     * Remark: 周 1-7
     */
    private Integer weekday;

    /**
     * Column: season
     * Remark: 季，0-3
     */
    private Integer season;

    /**
     * Column: yeer
     * Remark: 年
     */
    private Integer yeer;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRefsn() {
        return refsn;
    }

    public void setRefsn(String refsn) {
        this.refsn = refsn == null ? null : refsn.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday == null ? null : workday.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getYeer() {
        return yeer;
    }

    public void setYeer(Integer yeer) {
        this.yeer = yeer;
    }
}