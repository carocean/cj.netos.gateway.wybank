package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.*;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.gateway.wybank.model.TtmConfig;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.util.Encript;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@CjService(name = "/bank.ports")
public class WenyBankPorts implements IWenyBankPorts {
    @CjServiceSite
    IServiceSite site;

    @CjServiceRef
    IWenyBankService wenyBankService;

    private void demandAdminRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators") && !securitySession.roleIn("tenant:administrators") && !securitySession.roleIn("app:administrators") && !"system.netos".equals(securitySession.property("appid"))) {
            throw new CircuitException("800", "没有创建权限");
        }
    }

    @Override
    public BankInfo createWenyBank(ISecuritySession securitySession, WenyBankBO wenyBankBO) throws CircuitException {
        demandAdminRights(securitySession);
        if (wenyBankBO == null) {
            throw new CircuitException("404", "wenyBankBO 参数为空");
        }
        if (new BigDecimal(1.0).compareTo(wenyBankBO.getFreeRatio().add(wenyBankBO.getPrincipalRatio()).add(wenyBankBO.getReserveRatio())) != 0) {
            throw new CircuitException("500", "分单率相加不为1");
        }

        if (wenyBankBO == null) {
            throw new CircuitException("404", "wenyBankBO 参数为空");
        }
        return wenyBankService.createWenyBank(securitySession.principal(), wenyBankBO);
    }


    @Override
    public List<BankInfo> pageWenyBank(ISecuritySession securitySession, int limit, int offset) throws CircuitException {
        demandAdminRights(securitySession);
        if (limit == 0) {
            throw new CircuitException("500", "limit为0");
        }
        List<BankInfo> list = wenyBankService.pageWenyBank(limit, offset);
        return list;
    }

    @Override
    public List<BankInfo> getMyWenyBank(ISecuritySession securitySession) throws CircuitException {
        return wenyBankService.getMyWenyBanks(securitySession.principal());
    }

    @Override
    public List<BankInfo> pageWenyBankByCreators(ISecuritySession securitySession, List<String> creators, int limit, int offset) throws CircuitException {
        return wenyBankService.pageWenyBankByCreators(creators, limit, offset);
    }

    @Override
    public List<BankInfo> pageWenyBankByLicences(ISecuritySession securitySession, List<String> licences, int limit, int offset) throws CircuitException {
        return wenyBankService.pageWenyBankByLicences(licences, limit, offset);
    }

    @Override
    public List<BankInfo> pageWenyBankByDistricts(ISecuritySession securitySession, List<String> districts, int limit, int offset) throws CircuitException {
        return wenyBankService.pageWenyBankByDistricts(districts, limit, offset);
    }

    @Override
    public BankInfo getWenyBankByDistrict(ISecuritySession securitySession, String district) throws CircuitException {
        return wenyBankService.getWenyBankByDistrict(district);
    }

    @Override
    public BankInfo getAndAutoCreateWenyBankByDistrict(ISecuritySession securitySession, String district) throws CircuitException {
        BankInfo bankInfo = wenyBankService.getWenyBankByDistrict(district);
        if (bankInfo != null) {
            return bankInfo;
        }
        bankInfo = _selectPlatformSelfWenyBankDistrict();
        if (bankInfo == null) {
            throw new CircuitException("500", String.format("平台自营纹银银行一个都没有"));
        }
        WyBankForm form = _createBankForm(district, bankInfo);

        bankInfo = wenyBankService.createWenyBankByForm(form);
        return bankInfo;
    }

    private BankInfo _selectPlatformSelfWenyBankDistrict() throws CircuitException {
        //调用远程的org服务


        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.org.licence");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?limit=1&offset=0", ports);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "listLicenceOfPlatformSelf")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (Double.parseDouble(map.get("status") + "") >= 400) {
            throw new CircuitException(map.get("status") + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        List<Map<String, Object>> list = new Gson().fromJson(json, ArrayList.class);
        if (list.isEmpty()) {
            return null;
        }
        Map<String, Object> licence = list.get(0);
        String licenceId = (String) licence.get("id");
        return wenyBankService.getWenyBankByLicence(licenceId);
    }

    private WyBankForm _createBankForm(String district, BankInfo bankInfo) throws CircuitException {
        WyBankForm form = new WyBankForm();
        form.setCreator(bankInfo.getCreator());
        form.setDistrictCode(district);
        String districtTitle = _getDistrictTitleByAmap(district);
        if (StringUtil.isEmpty(districtTitle)) {
            throw new CircuitException("500", String.format("行政区%s不存在", district));
        }
        form.setDistrictTitle(districtTitle);
        String title=bankInfo.getTitle();
        int pos=title.lastIndexOf("-");
        if (pos > -1) {
            title = title.substring(0, pos);
        }
        form.setTitle(String.format("%s-%s", title, districtTitle));
        form.setIcon(bankInfo.getIcon());
        form.setLicence(bankInfo.getLicence());

        form.setPrincipalRatio(bankInfo.getPrincipalRatio());
        form.setServiceFeeRatio(bankInfo.getReserveRatio().add(bankInfo.getFreeRatio()));
        form.setReserveRatio(bankInfo.getReserveRatio());

        List<Shunter> shunters = wenyBankService.getShunters(bankInfo.getId());
        for (Shunter shunter : shunters) {
            switch (shunter.getCode()) {
                case "platform":
                    form.setPlatformRatio(shunter.getRatio());
                    break;
                case "isp":
                    form.setIspRatio(shunter.getRatio());
                    break;
                case "la":
                    form.setLaRatio(shunter.getRatio());
                    break;
                case "absorbs":
                    form.setAbsorbRatio(shunter.getRatio());
                    break;
            }
        }
        List<TtmConfig> ttmConfigList = wenyBankService.getTTMTable(bankInfo.getId());
        List<TtmInfo> ttmInfoList = new ArrayList<>();
        for (TtmConfig config : ttmConfigList) {
            TtmInfo info = new TtmInfo();
            info.setMaxAmount(config.getMaxAmount());
            info.setMinAmount(config.getMinAmount());
            info.setTtm(config.getTtm());
            ttmInfoList.add(info);
        }
        form.setTtmConfig(ttmInfoList);

        List<String> ispWithdrawers = new ArrayList<>();
        List<String> withdrawers = wenyBankService.getWithdrawRights(bankInfo.getId(), "isp");
        ispWithdrawers.addAll(withdrawers);
        form.setIspManagers(ispWithdrawers);

        return form;
    }

    private String _getDistrictTitleByAmap(String district) throws CircuitException {
        String ports = site.getProperty("amap.ports");
        ports = String.format("%s&keywords=%s&subdistrict=0&extensions=base", ports, district);
        OkHttpClient client = (OkHttpClient) site.getService("@.http");
        final Request request = new Request.Builder()
                .url(ports)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (map.get("status").equals("0")) {
            throw new CircuitException(map.get("infocode") + "", String.format("远程访问高德失败:%s", map.get("info") + ""));
        }
        List<Map<String, Object>> districts = (List<Map<String, Object>>) map.get("districts");
        if (districts.isEmpty()) {
            return null;
        }
        Map<String, Object> obj = districts.get(0);
        return (String) obj.get("name");
    }

    @Override
    public BankInfo getWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(banksn);
        return bankInfo;
    }

    @Override
    public BankInfo getWenyBankByLicence(ISecuritySession securitySession, String licence) throws CircuitException {
        if (StringUtil.isEmpty(licence)) {
            throw new CircuitException("404", "licence 参数为空");
        }
        BankInfo bankInfo = wenyBankService.getWenyBankByLicence(licence);
        return bankInfo;
    }

    @Override
    public BankInfo getWenyBankInfo(ISecuritySession securitySession, String banksn) throws CircuitException {
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(banksn);
        return bankInfo;
    }

    @Override
    public void stopWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.stopWenyBank(banksn);
    }

    @Override
    public void startWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.startWenyBank(banksn);
    }


    @Override
    public void cancelWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.cancelWenyBank(banksn);
    }


    @Override
    public void setShunters(ISecuritySession securitySession, String banksn, List<ShunterBO> shunters) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        BigDecimal count = new BigDecimal(0.0);
        List<Shunter> shunterList = new ArrayList<>();
        for (ShunterBO bo : shunters) {
            if (StringUtil.isEmpty(bo.getCode())) {
                throw new CircuitException("404", "分账器code为空");
            }
            Shunter shunter = new Shunter();
            shunter.setAlias(bo.getAlias());
            shunter.setBankid(banksn);
            shunter.setCode(bo.getCode());
            shunter.setRatio(bo.getRatio());
            shunter.setNote(bo.getNote());
            shunterList.add(shunter);

            count = count.add(bo.getRatio());
        }
        if (count.compareTo(new BigDecimal(1.0)) != 0) {
            throw new CircuitException("500", "分账套餐总和不为1");
        }
        wenyBankService.setShunters(banksn, shunterList);
    }


    @Override
    public void emptyShunters(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.emptyShunters(banksn);
    }


    @Override
    public List<ShunterBO> getShunters(ISecuritySession securitySession, String banksn) throws CircuitException {
        //权限先放开，之后实现只要是统一用户下的任何账号是其创建者则充许访问
//        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        List<Shunter> rules = wenyBankService.getShunters(banksn);
        List<ShunterBO> list = new ArrayList<>();
        for (Shunter shunter : rules) {
            ShunterBO bo = new ShunterBO();
            bo.setAlias(shunter.getAlias());
            bo.setBankid(shunter.getBankid());
            bo.setRatio(shunter.getRatio());
            bo.setCode(shunter.getCode());
            bo.setNote(shunter.getNote());
            list.add(bo);
        }
        return list;
    }


    @Override
    public List<TTMBO> getTTMTable(ISecuritySession securitySession, String banksn) throws CircuitException {
        //权限先放开，之后实现只要是统一用户下的任何账号是其创建者则充许访问
//        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        List<TtmConfig> ttmbos = wenyBankService.getTTMTable(banksn);
        List<TTMBO> list = new ArrayList<>();
        for (TtmConfig ttm : ttmbos) {
            TTMBO bo = new TTMBO();
            bo.setMaxAmount(ttm.getMaxAmount());
            bo.setMinAmount(ttm.getMinAmount());
            bo.setTtm(ttm.getTtm());
            list.add(bo);
        }
        return list;
    }


    @Override
    public void setTTMTable(ISecuritySession securitySession, String banksn, List<TTMBO> ttmTable) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.setTTMTable(banksn, ttmTable);
    }

    @Override
    public void emptyTTMTable(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        wenyBankService.emptyTTMTable(banksn);
    }

    @Override
    public void addWithdrawRights(ISecuritySession securitySession, String banksn, String shunter, String persons) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        if (StringUtil.isEmpty(shunter)) {
            throw new CircuitException("404", "shunter 参数为空");
        }
        if (StringUtil.isEmpty(persons)) {
            throw new CircuitException("404", "persons 参数为空");
        }
        List<String> personList = new ArrayList<>();
        String[] arr = persons.split(";");
        for (String p : arr) {
            if (StringUtil.isEmpty(p)) {
                continue;
            }
            personList.add(p);
        }
        wenyBankService.addWithdrawRights(banksn, shunter, personList);
    }

    @Override
    public void emptyWithdrawRights(ISecuritySession securitySession, String banksn, String shunter) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        if (StringUtil.isEmpty(shunter)) {
            throw new CircuitException("404", "shunter 参数为空");
        }
        wenyBankService.emptyWithdrawRights(banksn, shunter);
    }

    @Override
    public List<String> getWithdrawRights(ISecuritySession securitySession, String banksn, String shunter) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        if (StringUtil.isEmpty(shunter)) {
            throw new CircuitException("404", "shunter 参数为空");
        }
        return wenyBankService.getWithdrawRights(banksn, shunter);
    }
}
