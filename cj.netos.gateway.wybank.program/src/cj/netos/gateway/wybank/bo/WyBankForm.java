package cj.netos.gateway.wybank.bo;

import java.math.BigDecimal;
import java.util.List;

public class WyBankForm {
    String title;
    String icon;
    String licence;
    String districtTitle;
    String districtCode;
    String creator;
    List<String> ispManagers;
    BigDecimal serviceFeeRatio;
    BigDecimal reserveRatio;
    BigDecimal principalRatio;
    List<TtmInfo> ttmConfig;
    BigDecimal platformRatio;
    BigDecimal ispRatio;
    BigDecimal laRatio;
    BigDecimal absorbRatio;

    public List<String> getIspManagers() {
        return ispManagers;
    }

    public void setIspManagers(List<String> ispManagers) {
        this.ispManagers = ispManagers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public void setDistrictTitle(String districtTitle) {
        this.districtTitle = districtTitle;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public BigDecimal getServiceFeeRatio() {
        return serviceFeeRatio;
    }

    public void setServiceFeeRatio(BigDecimal serviceFeeRatio) {
        this.serviceFeeRatio = serviceFeeRatio;
    }

    public BigDecimal getReserveRatio() {
        return reserveRatio;
    }

    public void setReserveRatio(BigDecimal reserveRatio) {
        this.reserveRatio = reserveRatio;
    }

    public BigDecimal getPrincipalRatio() {
        return principalRatio;
    }

    public void setPrincipalRatio(BigDecimal principalRatio) {
        this.principalRatio = principalRatio;
    }

    public List<TtmInfo> getTtmConfig() {
        return ttmConfig;
    }

    public void setTtmConfig(List<TtmInfo> ttmConfig) {
        this.ttmConfig = ttmConfig;
    }

    public BigDecimal getPlatformRatio() {
        return platformRatio;
    }

    public void setPlatformRatio(BigDecimal platformRatio) {
        this.platformRatio = platformRatio;
    }

    public BigDecimal getIspRatio() {
        return ispRatio;
    }

    public void setIspRatio(BigDecimal ispRatio) {
        this.ispRatio = ispRatio;
    }

    public BigDecimal getLaRatio() {
        return laRatio;
    }

    public void setLaRatio(BigDecimal laRatio) {
        this.laRatio = laRatio;
    }

    public BigDecimal getAbsorbRatio() {
        return absorbRatio;
    }

    public void setAbsorbRatio(BigDecimal absorbRatio) {
        this.absorbRatio = absorbRatio;
    }
}
