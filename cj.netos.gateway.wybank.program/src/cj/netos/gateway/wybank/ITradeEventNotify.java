package cj.netos.gateway.wybank;

import cj.netos.gateway.wybank.model.WithdrawRecord;

public interface ITradeEventNotify {

    void sendToWallet(String command, String status, String message, Object content);

    void sendToAbsorbRobot(String command, String status, String message, Object content);

}
