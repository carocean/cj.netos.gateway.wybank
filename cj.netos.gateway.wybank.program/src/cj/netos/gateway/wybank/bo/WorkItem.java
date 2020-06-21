package cj.netos.gateway.wybank.bo;


public class WorkItem {
    WorkInst workInst;
    WorkEvent workEvent;

    public WorkItem() {
    }

    public WorkItem(WorkInst inst, WorkEvent event) {
        this.workInst = inst;
        this.workEvent = event;
    }

    public WorkInst getWorkInst() {
        return workInst;
    }

    public void setWorkInst(WorkInst workInst) {
        this.workInst = workInst;
    }

    public WorkEvent getWorkEvent() {
        return workEvent;
    }

    public void setWorkEvent(WorkEvent workEvent) {
        this.workEvent = workEvent;
    }
}
