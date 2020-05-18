package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.mapper.BankInfoMapper;
import cj.netos.gateway.wybank.mapper.ShunterMapper;
import cj.netos.gateway.wybank.mapper.TtmConfigMapper;
import cj.netos.gateway.wybank.mapper.WithdrawRightsMapper;
import cj.netos.gateway.wybank.model.*;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.openport.util.Encript;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CjBridge(aspects = "@transaction")
@CjService(name = "wenyBankService")
public class WenyBankService implements IWenyBankService {
    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.BankInfoMapper")
    BankInfoMapper bankInfoMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.ShunterMapper")
    ShunterMapper shunterMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.TtmConfigMapper")
    TtmConfigMapper ttmConfigMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.WithdrawRightsMapper")
    WithdrawRightsMapper withdrawRightsMapper;

    @CjTransaction
    @Override
    public BankInfo createWenyBank(String creator, WenyBankBO wenyBankBO) {
        BankInfo bankInfo = new BankInfo();
        bankInfo.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        bankInfo.setFreeRatio(wenyBankBO.getFreeRatio());
        try {
            bankInfo.setId(IdWorker.nextId());
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
    public void setShunters(String banksn, List<Shunter> shunters) {
        emptyShunters(banksn);
        for (Shunter shunter : shunters) {
            shunter.setBankid(banksn);
            shunterMapper.insert(shunter);
        }
    }

    @CjTransaction
    @Override
    public void emptyShunters(String banksn) {
        ShunterExample example = new ShunterExample();
        example.createCriteria().andBankidEqualTo(banksn);
        shunterMapper.deleteByExample(example);
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
    public List<Shunter> getShunters(String banksn) {
        ShunterExample example = new ShunterExample();
        example.createCriteria().andBankidEqualTo(banksn);
        return shunterMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<TtmConfig> getTTMTable(String banksn) {
        TtmConfigExample example = new TtmConfigExample();
        example.createCriteria().andBankidEqualTo(banksn);
        return ttmConfigMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public void addWithdrawRights(String banksn, String shunter, List<String> personList) {
        for (String person : personList) {
            WithdrawRights rights = new WithdrawRights();
            rights.setId(IdWorker.nextId());
            rights.setShunter(shunter);
            rights.setPerson(person);
            rights.setBankid(banksn);
            withdrawRightsMapper.insert(rights);
        }
    }

    @CjTransaction
    @Override
    public void emptyWithdrawRights(String banksn, String shunter) {
        WithdrawRightsExample example = new WithdrawRightsExample();
        example.createCriteria().andBankidEqualTo(banksn).andShunterEqualTo(shunter);
        withdrawRightsMapper.deleteByExample(example);
    }

    @CjTransaction
    @Override
    public List<String> getWithdrawRights(String banksn, String shunter) {
        WithdrawRightsExample example = new WithdrawRightsExample();
        example.createCriteria().andBankidEqualTo(banksn).andShunterEqualTo(shunter);
        List<WithdrawRights> list = withdrawRightsMapper.selectByExample(example);
        List<String> persons = new ArrayList<>();
        for (WithdrawRights rights : list) {
            persons.add(rights.getPerson());
        }
        return persons;
    }
}
