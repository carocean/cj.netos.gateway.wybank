package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;

/**
 * Table: shunter_rule
 */
public class ShunterRule {
    /**
     * Column: id
     * Remark: 标识
     */
    private String id;

    /**
     * Column: subject
     * Remark: 分账的目标主题,为英文。如：地商，平台，运营商，网络洇金，其它
     */
    private String subject;

    /**
     * Column: person
     * Remark: 分给谁，可为空，如分给网络洇金时person为空
     */
    private String person;

    /**
     * Column: ratio
     * Remark: 分账比例
     */
    private BigDecimal ratio;

    /**
     * Column: bankid
     * Remark: 每个行的可能不同
     */
    private String bankid;

    /**
     * Column: alias
     * Remark: 别名，为subject起个别名
     */
    private String alias;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }
}