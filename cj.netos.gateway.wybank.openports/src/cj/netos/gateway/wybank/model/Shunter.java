package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;

/**
 * Table: shunter
 */
public class Shunter {
    /**
     * Column: bankid
     * Remark: 每个行的可能不同
     */
    private String bankid;

    /**
     * Column: code
     * Remark: 分账者代码，如: Platform(平台）,operators（运营商），地商（landAgent），洇金（absorb)，等等
     */
    private String code;

    /**
     * Column: alias
     * Remark: Code对应的中文名: Platform(平台）,operators（运营商），地商（landAgent），洇金（absorb)，等等
     */
    private String alias;

    /**
     * Column: ratio
     * Remark: 分账比例
     */
    private BigDecimal ratio;

    /**
     * Column: note
     * Remark: 备注
     */
    private String note;

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}