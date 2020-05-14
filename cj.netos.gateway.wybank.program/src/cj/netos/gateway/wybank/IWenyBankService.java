package cj.netos.gateway.wybank;


import cj.netos.gateway.wybank.bo.ShunterRuleBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.ShunterRule;
import cj.netos.gateway.wybank.model.TtmConfig;

import java.util.List;

public interface IWenyBankService {
    BankInfo createWenyBank(String creator, WenyBankBO wenyBankBO);

    List<BankInfo> pageWenyBank(int limit, int offset);

    void stopWenyBank(String banksn);

    BankInfo getWenyBank(String banksn);

    void startWenyBank(String banksn);

    void cancelWenyBank(String banksn);

    void setShunterRules(String banksn, List<ShunterRuleBO> rules);

    void emptyShunterRules(String banksn);

    void setTTMTable(String banksn, List<TTMBO> ttmTable);

    void emptyTTMTable(String banksn);

    List<ShunterRule> getShunterRules(String banksn);

    List<TtmConfig> getTTMTable(String banksn);

}
