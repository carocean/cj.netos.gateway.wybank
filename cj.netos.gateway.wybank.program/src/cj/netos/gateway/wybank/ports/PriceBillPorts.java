package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.PriceBill;
import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.result.BulletinBoard;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.util.Encript;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

@CjService(name = "/bill/price.ports")
public class PriceBillPorts implements IPriceBillPorts {
    @CjServiceSite
    IServiceSite site;

    @CjServiceRef
    IWenyBankService wenyBankService;


    BankInfo demandBankOwner(ISecuritySession securitySession, String bankid) throws CircuitException {
        BankInfo bankInfo = wenyBankService.getWenyBank(bankid);
        if (bankInfo == null) {
            throw new CircuitException("404", "纹银银行不存在:" + bankid);
        }
        if (!securitySession.roleIn("platform:administrators") && !securitySession.principal().equals(bankInfo.getCreator())) {
            throw new CircuitException("800", String.format("拒绝访问。行号=%s", bankid));
        }
        return bankInfo;
    }

    @Override
    public List<PriceBill> pagePriceBill(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
//        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.price");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&limit=%s&offset=%s", ports, wenyBankID, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "pagePriceBill")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .addHeader("person", securitySession.principal())
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<PriceBill>>() {
        }.getType());
    }

    @Override
    public List<PriceBill> getAfterTimePriceBill(ISecuritySession securitySession, String wenyBankID, String ctime) throws CircuitException {
        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.price");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&ctime=%s", ports, wenyBankID, ctime);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "getAfterTimePriceBill")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .addHeader("person", securitySession.principal())
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<PriceBill>>() {
        }.getType());
    }

    @Override
    public List<PriceBill> getPriceBillOfMonth(ISecuritySession securitySession, String wenyBankID, int year, int month, int limit, long offset) throws CircuitException {
//        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.price");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s&limit=%s&offset=%s", ports, wenyBankID, year, month, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "getPriceBillOfMonth")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .addHeader("person", securitySession.principal())
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<PriceBill>>() {
        }.getType());
    }

    @Override
    public List<PriceBill> getPriceBillOfDay(ISecuritySession securitySession, String wenyBankID, int year, int month, int day, int limit, long offset) throws CircuitException {
//        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.price");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s&day=%s&limit=%s&offset=%s", ports, wenyBankID, year, month, day, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "getPriceBillOfDay")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .addHeader("person", securitySession.principal())
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<PriceBill>>() {
        }.getType());
    }

    @Override
    public BulletinBoard getBulletinBoard(ISecuritySession securitySession, String wenyBankID, int year, int month, int day) throws CircuitException {
        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.price");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s&day=%s", ports, wenyBankID, year, month, day);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "getBulletinBoard")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .addHeader("person", securitySession.principal())
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
        return new Gson().fromJson(json, BulletinBoard.class);
    }
}
