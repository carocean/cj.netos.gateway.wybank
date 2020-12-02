package cj.netos.gateway.wybank.service;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.TtmInfo;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.bo.WyBankForm;
import cj.netos.gateway.wybank.mapper.*;
import cj.netos.gateway.wybank.model.*;
import cj.netos.gateway.wybank.util.BankUtils;
import cj.netos.gateway.wybank.util.IdWorker;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.openport.util.Encript;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.Arrays;
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

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.IncubatorMapper")
    IncubatorMapper incubatorMapper;

    @CjServiceRef(refByName = "mybatis.cj.netos.gateway.wybank.mapper.IncubatorEventsMapper")
    IncubatorEventsMapper incubatorEventsMapper;

    @CjTransaction
    @Override
    public void putBankOnIncubator(String banksn) {
        BankInfo bankInfo = getWenyBank(banksn);
        if (bankInfo == null) {
            return;
        }
        Incubator incubator = new Incubator();
        incubator.setBank(banksn);
        incubator.setDistrictCode(bankInfo.getDistrictCode());
        incubator.setDistrictTitle(bankInfo.getDistrictTitle());
        incubator.setState(1);
        incubatorMapper.insert(incubator);

        IncubatorEvents events = new IncubatorEvents();
        events.setId(new IdWorker().nextId());
        events.setCtime(BankUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        events.setBank(banksn);
        events.setType("put");
        events.setName("放入");
        incubatorEventsMapper.insert(events);

        IncubatorEvents events2 = new IncubatorEvents();
        events2.setId(new IdWorker().nextId());
        events2.setCtime(BankUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        events2.setBank(banksn);
        events2.setType("start");
        events2.setName("启用");
        incubatorEventsMapper.insert(events2);
    }

    @CjTransaction
    @Override
    public void stopBankOnIncubator(String banksn) {
        incubatorMapper.updateState(banksn, 0);
        IncubatorEvents events = new IncubatorEvents();
        events.setId(new IdWorker().nextId());
        events.setCtime(BankUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        events.setBank(banksn);
        events.setType("stop");
        events.setName("停止");
        incubatorEventsMapper.insert(events);
    }

    @CjTransaction
    @Override
    public void restartBankOnIncubator(String banksn) {
        incubatorMapper.updateState(banksn, 1);
        IncubatorEvents events = new IncubatorEvents();
        events.setId(new IdWorker().nextId());
        events.setCtime(BankUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        events.setBank(banksn);
        events.setType("restart");
        events.setName("重启");
        incubatorEventsMapper.insert(events);
    }

    @CjTransaction
    @Override
    public void removeBankOnIncubator(String banksn) {
        incubatorMapper.deleteByPrimaryKey(banksn);
        IncubatorEvents events = new IncubatorEvents();
        events.setId(new IdWorker().nextId());
        events.setCtime(BankUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        events.setBank(banksn);
        events.setType("remove");
        events.setName("移除");
        incubatorEventsMapper.insert(events);
    }

    @CjTransaction
    @Override
    public List<Incubator> listBankOnIncubator() {
        IncubatorExample example = new IncubatorExample();
        return incubatorMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<Incubator> listAvailableBankOnIncubator() {
        IncubatorExample example = new IncubatorExample();
        example.createCriteria().andStateEqualTo(1);
        return incubatorMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<IncubatorEvents> listBankEventsOnIncubator(String banksn) {
        IncubatorEventsExample example = new IncubatorEventsExample();
        example.createCriteria().andBankEqualTo(banksn);
        return incubatorEventsMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public BankInfo createWenyBank(String creator, WenyBankBO wenyBankBO) {
        BankInfo bankInfo = new BankInfo();
        bankInfo.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        bankInfo.setFreeRatio(wenyBankBO.getFreeRatio());
        bankInfo.setId(IdWorker.nextId());
        bankInfo.setDistrictCode(wenyBankBO.getDistrictCode());
        bankInfo.setDistrictTitle(wenyBankBO.getDistrictTitle());
        bankInfo.setPrincipalRatio(wenyBankBO.getPrincipalRatio());
        bankInfo.setReserveRatio(wenyBankBO.getReserveRatio());
        bankInfo.setState(0);
        bankInfo.setForceUsed(0);
        bankInfo.setTitle(wenyBankBO.getTitle());
        bankInfo.setCreator(creator);
        bankInfo.setLicence(wenyBankBO.getLicence());

        bankInfoMapper.insert(bankInfo);
        return bankInfo;
    }

    @CjTransaction
    @Override
    public BankInfo createWenyBankByForm(WyBankForm form) {
        BankInfo bankInfo = new BankInfo();
        bankInfo.setCtime(BankUtils.dateTimeToSecond(System.currentTimeMillis()));
        bankInfo.setId(IdWorker.nextId());
        bankInfo.setDistrictCode(form.getDistrictCode());
        bankInfo.setDistrictTitle(form.getDistrictTitle());
        bankInfo.setFreeRatio(form.getServiceFeeRatio().subtract(form.getReserveRatio()));
        bankInfo.setPrincipalRatio(form.getPrincipalRatio());
        bankInfo.setReserveRatio(form.getReserveRatio());
        bankInfo.setState(0);
        bankInfo.setForceUsed(0);
        bankInfo.setTitle(form.getTitle());
        bankInfo.setCreator(form.getCreator());
        bankInfo.setLicence(form.getLicence());
        bankInfo.setIcon(form.getIcon());

        bankInfoMapper.insert(bankInfo);

        List<Shunter> shunters = new ArrayList<>();
        Shunter _platformShunter = new Shunter();
        _platformShunter.setAlias("平台");
        _platformShunter.setBankid(bankInfo.getId());
        _platformShunter.setCode("platform");
        _platformShunter.setRatio(form.getPlatformRatio());
        shunters.add(_platformShunter);

        Shunter _ispShunter = new Shunter();
        _ispShunter.setAlias("运营商");
        _ispShunter.setBankid(bankInfo.getId());
        _ispShunter.setCode("isp");
        _ispShunter.setRatio(form.getIspRatio());
        shunters.add(_ispShunter);

        Shunter _laShunter = new Shunter();
        _laShunter.setAlias("地商");
        _laShunter.setBankid(bankInfo.getId());
        _laShunter.setCode("la");
        _laShunter.setRatio(form.getLaRatio());
        shunters.add(_laShunter);

        Shunter _absorbShunter = new Shunter();
        _absorbShunter.setAlias("网络洇金");
        _absorbShunter.setBankid(bankInfo.getId());
        _absorbShunter.setCode("absorbs");
        _absorbShunter.setRatio(form.getAbsorbRatio());
        shunters.add(_absorbShunter);

        setShunters(bankInfo.getId(), shunters);

        //添加提现权限
        addWithdrawRights(bankInfo.getId(), _absorbShunter.getCode(), Arrays.asList(_KEY_ABSORB_WITHDRAWER));//吸收机器人，用于分发网络洇金
        addWithdrawRights(bankInfo.getId(), _laShunter.getCode(), Arrays.asList(form.getCreator()));
        if (form.getIspManagers() != null) {
            for (String mananger : form.getIspManagers()) {
                addWithdrawRights(bankInfo.getId(), _ispShunter.getCode(), Arrays.asList(mananger));
            }
        }

        List<TTMBO> ttmTable = new ArrayList<>();
        for (TtmInfo ttmInfo : form.getTtmConfig()) {
            TTMBO ttmbo = new TTMBO();
            ttmbo.setMaxAmount(ttmInfo.getMaxAmount());
            ttmbo.setMinAmount(ttmInfo.getMinAmount());
            ttmbo.setTtm(ttmInfo.getTtm());
            ttmTable.add(ttmbo);
        }
        setTTMTable(bankInfo.getId(), ttmTable);
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
    public void forceUseWenyBank(String banksn) {
        bankInfoMapper.updateForceUsed(banksn, 1);
    }

    @CjTransaction
    @Override
    public void unforceUseWenyBank(String banksn) {
        bankInfoMapper.updateForceUsed(banksn, 0);
    }

    @CjTransaction
    @Override
    public BankInfo getWenyBank(String banksn) {
        return bankInfoMapper.selectByPrimaryKey(banksn);
    }

    @CjTransaction
    @Override
    public List<BankInfo> getMyWenyBanks(String creator) {
        BankInfoExample example = new BankInfoExample();
        example.createCriteria().andCreatorEqualTo(creator);
        return bankInfoMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public BankInfo getWenyBankByDistrict(String district) {
        BankInfoExample example = new BankInfoExample();
        example.createCriteria().andDistrictCodeEqualTo(district);
        List<BankInfo> list = bankInfoMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @CjTransaction
    @Override
    public List<BankInfo> pageWenyBankByCreators(List<String> creators, int limit, int offset) {
        StringBuffer sb = new StringBuffer();
        for (String creator : creators) {
            sb.append(String.format("'%s',", creator));
        }
        if (!creators.isEmpty()) {
            sb.append("''");
        }
        return bankInfoMapper.pageWenyBankByCreators(sb.toString(), limit, offset);
    }

    @CjTransaction
    @Override
    public List<BankInfo> pageWenyBankByLicences(List<String> licences, int limit, int offset) {
        StringBuffer sb = new StringBuffer();
        for (String creator : licences) {
            sb.append(String.format("'%s',", creator));
        }
        if (!licences.isEmpty()) {
            sb.append("''");
        }
        return bankInfoMapper.pageWenyBankByLicences(sb.toString(), limit, offset);
    }

    @CjTransaction
    @Override
    public List<BankInfo> pageWenyBankByDistricts(List<String> districts, int limit, int offset) {
        StringBuffer sb = new StringBuffer();
        for (String creator : districts) {
            sb.append(String.format("'%s',", creator));
        }
        if (!districts.isEmpty()) {
            sb.append("''");
        }
        return bankInfoMapper.pageWenyBankByDistricts(sb.toString(), limit, offset);
    }

    @CjTransaction
    @Override
    public BankInfo getWenyBankByLicence(String licence) {
        BankInfoExample example = new BankInfoExample();
        example.createCriteria().andLicenceEqualTo(licence);
        List<BankInfo> list = bankInfoMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
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
