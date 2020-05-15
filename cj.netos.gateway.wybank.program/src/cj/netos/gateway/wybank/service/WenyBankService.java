package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.ShunterRuleBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.mapper.BankInfoMapper;
import cj.netos.gateway.wybank.mapper.ShunterRuleMapper;
import cj.netos.gateway.wybank.mapper.TtmConfigMapper;
import cj.netos.gateway.wybank.model.*;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.openport.util.Encript;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;
import java.util.UUID;

@CjBridge(aspects = "@transaction")
@CjService(name = "wenyBankService")
public class WenyBankService implements IWenyBankService {
    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.BankInfoMapper")
    BankInfoMapper bankInfoMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShunterRuleMapper")
    ShunterRuleMapper shunterRuleMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.TtmConfigMapper")
    TtmConfigMapper ttmConfigMapper;

    @CjTransaction
    @Override
    public BankInfo createWenyBank(String creator, WenyBankBO wenyBankBO) {
        BankInfo bankInfo = new BankInfo();
        bankInfo.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        bankInfo.setFreeRatio(wenyBankBO.getFreeRatio());
        try {
            bankInfo.setId(IdWorker.nextId() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        bankInfo.setLocation(wenyBankBO.getLocation());
        bankInfo.setOwner(wenyBankBO.getOwner());
        bankInfo.setPrincipalRatio(wenyBankBO.getPrincipalRatio());
        bankInfo.setProperty(wenyBankBO.getProperty());
        bankInfo.setReserveRatio(wenyBankBO.getReserveRatio());
        bankInfo.setState(0);
        bankInfo.setTitle(wenyBankBO.getTitle());
        bankInfo.setCreator(creator);
        bankInfoMapper.insert(bankInfo);
        return bankInfo;
    }

    @CjTransaction
    @Override
    public List<BankInfo> pageWenyBank(int limit, int offset) {
        return bankInfoMapper.pageWenyBank(limit, offset);
    }

    @CjTransaction
    @Override
    public void stopWenyBank(String banksn) {
        bankInfoMapper.updateState(banksn, 1);
    }

    @CjTransaction
    @Override
    public BankInfo getWenyBank(String banksn) {
        return bankInfoMapper.selectByPrimaryKey(banksn);
    }

    @CjTransaction
    @Override
    public void startWenyBank(String banksn) {
        bankInfoMapper.updateState(banksn, 0);
    }

    @CjTransaction
    @Override
    public void cancelWenyBank(String banksn) {
        bankInfoMapper.updateState(banksn, 2);
    }

    @CjTransaction
    @Override
    public void setShunterRules(String banksn, List<ShunterRuleBO> rules) {
        emptyShunterRules(banksn);
        for (ShunterRuleBO bo : rules) {
            ShunterRule rule = new ShunterRule();
            rule.setBankid(banksn);
            rule.setId(Encript.md5(UUID.randomUUID().toString()));
            rule.setPerson(bo.getPerson());
            rule.setSubject(bo.getSubject());
            rule.setRatio(bo.getRatio());
            rule.setAlias(bo.getAlias());
            shunterRuleMapper.insert(rule);
        }
    }

    @CjTransaction
    @Override
    public void emptyShunterRules(String banksn) {
        ShunterRuleExample example = new ShunterRuleExample();
        example.createCriteria().andBankidEqualTo(banksn);
        shunterRuleMapper.deleteByExample(example);
    }

    @CjTransaction
    @Override
    public void setTTMTable(String banksn, List<TTMBO> ttmTable) {
        emptyTTMTable(banksn);
        for (TTMBO bo : ttmTable) {
            TtmConfig config = new TtmConfig();
            config.setBankid(banksn);
            config.setId(Encript.md5(UUID.randomUUID().toString()));
            config.setTtm(bo.getTtm());
            config.setMaxAmount(bo.getMaxAmount());
            config.setMinAmount(bo.getMinAmount());
            ttmConfigMapper.insert(config);
        }
    }

    @CjTransaction
    @Override
    public void emptyTTMTable(String banksn) {
        TtmConfigExample example = new TtmConfigExample();
        example.createCriteria().andBankidEqualTo(banksn);
        ttmConfigMapper.deleteByExample(example);
    }

    @CjTransaction
    @Override
    public List<ShunterRule> getShunterRules(String banksn) {
        ShunterRuleExample example = new ShunterRuleExample();
        example.createCriteria().andBankidEqualTo(banksn);
        return shunterRuleMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<TtmConfig> getTTMTable(String banksn) {
        TtmConfigExample example = new TtmConfigExample();
        example.createCriteria().andBankidEqualTo(banksn);
        return ttmConfigMapper.selectByExample(example);
    }
}
