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
        return wenyBankService.pageWenyBankByCreators(creators,limit,offset);
    }

    @Override
    public List<BankInfo> pageWenyBankByLicences(ISecuritySession securitySession, List<String> licences, int limit, int offset) throws CircuitException {
        return wenyBankService.pageWenyBankByLicences(licences,limit,offset);
    }

    @Override
    public List<BankInfo> pageWenyBankByDistricts(ISecuritySession securitySession, List<String> districts, int limit, int offset) throws CircuitException {
        return wenyBankService.pageWenyBankByDistricts(districts,limit,offset);
    }

    @Override
    public BankInfo getWenyBankByDistrict(ISecuritySession securitySession, String district) throws CircuitException {
        return wenyBankService.getWenyBankByDistrict(district);
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
