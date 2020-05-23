package cj.netos.gateway.wybank;

public interface ITradeEventNotify {

    void send(String command, String status, String message, Object content);

}
