package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.IWenyBankService;
import cj.netos.gateway.wybank.bo.StockBill;
import cj.netos.gateway.wybank.model.BankInfo;
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
import java.math.BigDecimal;
import java.util.*;

@CjService(name = "/bill/stock.ports")
public class StockBillPorts implements IStockBillPorts {
    @CjServiceSite
    IServiceSite site;

    @CjServiceRef
    IWenyBankService wenyBankService;


    BankInfo demandBankOwner(ISecuritySession securitySession, String bankid) throws CircuitException {
        BankInfo bankInfo = wenyBankService.getWenyBank(bankid);
        if (bankInfo == null) {
            throw new CircuitException("404", "纹银银行不存在:" + bankid);
        }
//        if (!securitySession.roleIn("platform:administrators") && !securitySession.principal().equals(bankInfo.getCreator())) {
//            throw new CircuitException("800", String.format("拒绝访问。行号=%s", bankid));
//        }
        return bankInfo;
    }

    @Override
    public List<StockBill> pageBill(ISecuritySession securitySession, String wenyBankID, int limit, long offset) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&limit=%s&offset=%s", ports, wenyBankID, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "pageBill")
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<StockBill>>() {
        }.getType());
    }

    @Override
    public List<StockBill> pageBillOfMonth(ISecuritySession securitySession, String wenyBankID, int order, int year, int month, int limit, long offset) throws CircuitException {
        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&order=%s&year=%s&month=%s&limit=%s&offset=%s", ports, wenyBankID,order, year, month, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "pageBillOfMonth")
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<StockBill>>() {
        }.getType());
    }

    @Override
    public List<StockBill> getBillOfMonth(ISecuritySession securitySession, String wenyBankID, int year, int month, int limit, long offset) throws CircuitException {
//        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s&limit=%s&offset=%s", ports, wenyBankID, year, month, limit, offset);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "getBillOfMonth")
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<StockBill>>() {
        }.getType());
    }

    @Override
    public BigDecimal totalInBillOfMonth(ISecuritySession securitySession, String wenyBankID, int year, int month) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s", ports, wenyBankID, year, month);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "totalInBillOfMonth")
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
        return new Gson().fromJson(json, BigDecimal.class);
    }


    @Override
    public BigDecimal totalOutBillOfMonth(ISecuritySession securitySession, String wenyBankID, int year, int month) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s&month=%s", ports, wenyBankID, year, month);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "totalOutBillOfMonth")
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
        return new Gson().fromJson(json, BigDecimal.class);
    }

    @Override
    public BigDecimal totalOutBillOfYear(ISecuritySession securitySession, String wenyBankID, int year) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s", ports, wenyBankID, year);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "totalOutBillOfYear")
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
        return new Gson().fromJson(json, BigDecimal.class);
    }

    @Override
    public BigDecimal totalInBillOfYear(ISecuritySession securitySession, String wenyBankID, int year) throws CircuitException {
        demandBankOwner(securitySession, wenyBankID);

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String ports = site.getProperty("ports.oc.wybank.bill.stock");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String portsUrl = String.format("%s?wenyBankID=%s&year=%s", ports, wenyBankID, year);
        final Request request = new Request.Builder()
                .url(portsUrl)
                .addHeader("Rest-Command", "totalInBillOfYear")
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
        return new Gson().fromJson(json, BigDecimal.class);
    }
}
