package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;

public class WenyBankBO {
    private String title;
    private String owner;
    private Integer property;
    private String location;
    private BigDecimal principalRatio;
    private BigDecimal reserveRatio;
    private BigDecimal freeRatio;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
