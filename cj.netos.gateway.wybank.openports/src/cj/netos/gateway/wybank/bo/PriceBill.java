package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;

/**
 * Table: price_bill
 */
public class PriceBill {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: refid
     * Remark: 关联购买或承兑流水单号
     */
    private String refid;

    /**
     * Column: price
     * Remark: 当前价
     */
    private BigDecimal price;

    /**
     * Column: after_price
     * Remark: 变动后价格
     */
    private BigDecimal afterPrice;

    /**
     * Column: order
     * Remark: 指令：0申购、1承兑
     */
    private Integer order;

    /**
     * Column: refsn
     * Remark: 关联申购或承兑或分账流水号
     */
    private String refsn;

    /**
     * Column: participant
     */
    private String participant;

    /**
     * Column: title
     * Remark: 显示名
     */
    private String title;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: bankid
     */
    private String bankid;

    /**
     * Column: note
     */
    private String note;

    /**
     * Column: workday
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

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAfterPrice() {
        return afterPrice;
    }

    public void setAfterPrice(BigDecimal afterPrice) {
        this.afterPrice = afterPrice;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getRefsn() {
        return refsn;
    }

    public void setRefsn(String refsn) {
        this.refsn = refsn == null ? null : refsn.trim();
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
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

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
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