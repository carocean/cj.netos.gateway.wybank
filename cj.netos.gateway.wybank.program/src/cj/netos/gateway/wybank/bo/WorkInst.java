package cj.netos.gateway.wybank.bo;

/**
 * Table: work_inst
 */
public class WorkInst {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: name
     * Remark: 工作项标题 从工作流拷贝
     */
    private String name;

    /**
     * Column: workflow
     * Remark: 关联工作流标识
     */
    private String workflow;

    /**
     * Column: ctime
     * Remark: 工作项创建时间
     */
    private String ctime;

    /**
     * Column: is_done
     * Remark: 工作流程是否已完成 1完成 0未完成
     */
    private Integer isDone;

    /**
     * Column: icon
     * Remark: 从工作流拷贝
     */
    private String icon;

    /**
     * Column: creator
     * Remark: 工作项的创建者
     */
    private String creator;

    /**
     * Column: note
     * Remark: 从工作流拷贝
     */
    private String note;

    /**
     * Column: data
     * Remark: 工作数据。由工作事件来追溯其变更的过程
     */
    private String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow == null ? null : workflow.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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