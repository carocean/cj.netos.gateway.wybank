package cj.netos.gateway.wybank.bo;

/**
 * Table: work_event
 */
public class WorkEvent {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: title
     * Remark: 事件名,在工作实例中指步骤名
     */
    private String title;

    /**
     * Column: code
     * Remark: 事件代码，即步骤的英文名，在一个实例中唯一，它也用来标记实例的结束
     */
    private String code;

    /**
     * Column: step_no
     * Remark: 操作步骤。为++。用于让程序判断走到哪了（由于是简易工作流所以没有预定步聚而是让程序自由解释）
     */
    private Integer stepNo;

    /**
     * Column: work_inst
     * Remark: 关联的工作实例
     */
    private String workInst;

    /**
     * Column: ctime
     * Remark: 流程的创建时间
     */
    private String ctime;

    /**
     * Column: sender
     */
    private String sender;

    /**
     * Column: recipient
     * Remark: 事件的接收方，公号格式
     */
    private String recipient;

    /**
     * Column: operated
     * Remark: 已发生的操作。如已审批｜已发申请等，由程序定义每一step是什么操作，下一步需要根据前边的操作做什么
     */
    private String operated;

    /**
     * Column: is_done
     * Remark: 状态 0为未完成 1为已完成
     */
    private Integer isDone;

    /**
     * Column: prev_event
     * Remark: 前一步事件id
     */
    private String prevEvent;

    /**
     * Column: dtime
     * Remark: 完成时间
     */
    private String dtime;

    /**
     * Column: note
     */
    private String note;

    /**
     * Column: data
     * Remark: 数据，每个事件的数据均是从工作实例的data而来，它记录了工作实例上data的版本变化情况，所以工作实例上的data虽然保持的是最新的，但可通过事件追溯它
     */
    private String data;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStepNo() {
        return stepNo;
    }

    public void setStepNo(Integer stepNo) {
        this.stepNo = stepNo;
    }

    public String getWorkInst() {
        return workInst;
    }

    public void setWorkInst(String workInst) {
        this.workInst = workInst == null ? null : workInst.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public String getOperated() {
        return operated;
    }

    public void setOperated(String operated) {
        this.operated = operated == null ? null : operated.trim();
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    public String getPrevEvent() {
        return prevEvent;
    }

    public void setPrevEvent(String prevEvent) {
        this.prevEvent = prevEvent == null ? null : prevEvent.trim();
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime == null ? null : dtime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}