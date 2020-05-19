package cj.netos.gateway.wybank.bo;

/**
 * Table: shunter_bill
 */
public class ShunterBill {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: title
     * Remark: 显示名，一般是人中文名
     */
    private String title;

    /**
     * Column: participant
     * Remark: 参与者：申购人或提现人
     */
    private String participant;

    /**
     * Column: shunter
     * Remark: 分账器
     */
    private String shunter;

    /**
     * Column: bankid
     */
    private String bankid;

    /**
     * Column: order
     * Remark: 指令： 0申购流水号 1分账器提现流水号
     */
    private Integer order;

    /**
     * Column: amount
     * Remark: 分账的发生额
     */
    private Long amount;

    /**
     * Column: balance
     * Remark: 变化后的资金现量余额
     */
    private Long balance;

    /**
     * Column: refsn
     * Remark: 关联申购流水号或分账器提现流水号
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

    public String getShunter() {
        return shunter;
    }

    public void setShunter(String shunter) {
        this.shunter = shunter == null ? null : shunter.trim();
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
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
}