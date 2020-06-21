package cj.netos.gateway.wybank;


import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.netos.gateway.wybank.bo.WyBankForm;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.gateway.wybank.model.TtmConfig;

import java.util.List;

public interface IWenyBankService {
    BankInfo createWenyBank(String creator, WenyBankBO wenyBankBO);

    List<BankInfo> pageWenyBank(int limit, int offset);

    void stopWenyBank(String banksn);

    BankInfo getWenyBank(String banksn);

    void startWenyBank(String banksn);

    void cancelWenyBank(String banksn);

    void setShunters(String banksn, List<Shunter> rules);

    void emptyShunters(String banksn);

    void setTTMTable(String banksn, List<TTMBO> ttmTable);

    void emptyTTMTable(String banksn);

    List<Shunter> getShunters(String banksn);

    List<TtmConfig> getTTMTable(String banksn);

    void addWithdrawRights(String banksn, String shunter, List<String> personList);

    void emptyWithdrawRights(String banksn, String shunter);

    List<String> getWithdrawRights(String banksn, String shunter);

    void createWenyBankByForm(WyBankForm form);

}
