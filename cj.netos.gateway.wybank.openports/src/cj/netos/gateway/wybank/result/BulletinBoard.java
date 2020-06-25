package cj.netos.gateway.wybank.result;

import java.math.BigDecimal;

public class BulletinBoard {
    BigDecimal openPrice;//今开
    BigDecimal closePrice;//昨收

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }
}
