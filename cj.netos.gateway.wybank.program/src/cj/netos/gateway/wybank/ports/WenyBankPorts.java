package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.ShunterBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.gateway.wybank.model.TtmConfig;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;

import java.math.BigDecimal;
import java.util.*;

@CjService(name = "/bank.ports")
public class WenyBankPorts implements IWenyBankPorts {
    @CjServiceSite
    IServiceSite site;

    @CjServiceRef
    IWenyBankService wenyBankService;

    private void demandAdminRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators") && !securitySession.roleIn("tenant:administrators") && !securitySession.roleIn("app:administrators")) {
            throw new CircuitException("800", "没有创建权限");
        }
    }

    @Override
    public Map<String, Object> createWenyBank(ISecuritySession securitySession, WenyBankBO wenyBankBO) throws CircuitException {
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
        Object obj = wenyBankService.createWenyBank(securitySession.principal(), wenyBankBO);
        return new Gson().fromJson(new Gson().toJson(obj), HashMap.class);
    }


    @Override
    public List<Map<String, Object>> pageWenyBank(ISecuritySession securitySession, int limit, int offset) throws CircuitException {
        demandAdminRights(securitySession);
        if (limit == 0) {
            throw new CircuitException("500", "limit为0");
        }
        List<BankInfo> list = wenyBankService.pageWenyBank(limit, offset);
        return new Gson().fromJson(new Gson().toJson(list), ArrayList.class);
    }

    @Override
    public Map<String, Object> getWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        BankInfo bankInfo = wenyBankService.getWenyBank(banksn);
        return new Gson().fromJson(new Gson().toJson(bankInfo), HashMap.class);
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
        for (ShunterBO rule : shunters) {
            count = count.add(rule.getRatio());
        }
        if (count.compareTo(new BigDecimal(1.0)) != 0) {
            throw new CircuitException("500", "分账套餐总和不为1");
        }
        List<Shunter> shunterList = new ArrayList<>();
        for (ShunterBO bo : shunters) {
            if (StringUtil.isEmpty(bo.getCode())) {
                throw new CircuitException("404", "分账器code为空");
            }
            Shunter shunter = new Shunter();
            shunter.setAlias(bo.getAlias());
            shunter.setBankid(bo.getBankid());
            shunter.setCode(bo.getCode());
            shunter.setRatio(bo.getRatio());
            shunter.setNote(bo.getNote());
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
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        List<Shunter> rules = wenyBankService.getShunters(banksn);
        List<ShunterBO> list = new ArrayList<>();
        for (Shunter shunter : rules) {
            ShunterBO bo = new ShunterBO();
            bo.setAlias(shunter.getAlias());
            bo.setBankid( shunter.getBankid());
            bo.setRatio(shunter.getRatio());
            bo.setCode(shunter.getCode());
            bo.setNote(shunter.getNote());
            list.add(bo);
        }
        return list;
    }


    @Override
    public List<TTMBO> getTTMTable(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
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
        String[] arr=persons.split(";");
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
      return  wenyBankService.getWithdrawRights(banksn, shunter);
    }
}
