package cj.netos.gateway.wybank.model;

/**
 * Table: withdraw_rights
 */
public class WithdrawRights {
    /**
     * Column: id
     */
    private String id;

    /**
     * Column: person
     */
    private String person;

    /**
     * Column: shunter
     * Remark: 哪个分账器的权限
     */
    private String shunter;

    /**
     * Column: bankid
     */
    private String bankid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
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
}