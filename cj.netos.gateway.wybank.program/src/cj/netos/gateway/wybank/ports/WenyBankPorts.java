package cj.netos.gateway.wybank.ports;

import cj.netos.gateway.wybank.bo.ShunterRuleBO;
import cj.netos.gateway.wybank.bo.TTMBO;
import cj.netos.gateway.wybank.bo.WenyBankBO;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.util.Encript;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.gson2.com.google.gson.reflect.TypeToken;
import cj.ultimate.util.StringUtil;
import okhttp3.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@CjService(name = "/bank.ports")
public class WenyBankPorts implements IWenyBankPorts {
    @CjServiceSite
    IServiceSite site;

    private void demandAdminRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators") && !securitySession.roleIn("tenant:administrators") && !securitySession.roleIn("app:administrators")) {
            throw new CircuitException("800", "没有创建权限");
        }
    }

    @Override
    public Map<String, Object> createWenyBank(ISecuritySession securitySession, WenyBankBO wenyBankBO) throws CircuitException {
        demandAdminRights(securitySession);
        if (wenyBankBO == null) {
            throw new CircuitException("404", "wenyBankBO 参数为空");
        }
        if (new BigDecimal(1.0).compareTo(wenyBankBO.getFreeRatio().add(wenyBankBO.getPrincipalRatio()).add(wenyBankBO.getReserveRatio())) != 0) {
            throw new CircuitException("500", "分单率相加不为1");
        }

        return call_createWenyBank(securitySession.principal(), wenyBankBO);
    }


    protected Map<String, Object> call_createWenyBank(String person, WenyBankBO wenyBankBO) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        Map<String, Object> args = new HashMap<>();
        args.put("wenyBankBO", wenyBankBO);
        RequestBody body = RequestBody.create(new Gson().toJson(args).getBytes());
        final Request request = new Request.Builder()
                .url(String.format("%s?creator=%s", portsUrl, person))
                .addHeader("Rest-Command", "createWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .post(body)
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
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }

    @Override
    public List<Map<String, Object>> pageWenyBank(ISecuritySession securitySession, int limit, int offset) throws CircuitException {
        demandAdminRights(securitySession);
        if (limit == 0) {
            throw new CircuitException("500", "limit为0");
        }
        return call_pageWenyBank(limit, offset);
    }

    protected List<Map<String, Object>> call_pageWenyBank(int limit, int offset) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?limit=%s&offset=%s", portsUrl, limit, offset))
                .addHeader("Rest-Command", "pageWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
        ArrayList list = new Gson().fromJson(json, ArrayList.class);
        return list;
    }

    @Override
    public Map<String, Object> getWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        return call_getWenyBank(banksn);
    }

    protected Map<String, Object> call_getWenyBank(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "getWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }

    @Override
    public void stopWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_stopWenyBank(banksn);
    }

    protected void call_stopWenyBank(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "stopWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
    }

    @Override
    public void startWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_startWenyBank(banksn);
    }

    protected void call_startWenyBank(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "startWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
    }

    @Override
    public void cancelWenyBank(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_cancelWenyBank(banksn);
    }

    protected void call_cancelWenyBank(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "cancelWenyBank")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
    }

    @Override
    public void setShunterRules(ISecuritySession securitySession, String banksn, List<ShunterRuleBO> rules) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        BigDecimal count = new BigDecimal(0.0);
        for (ShunterRuleBO rule : rules) {
            count = count.add(rule.getRatio());
        }
        if (count.compareTo(new BigDecimal(1.0)) != 0) {
            throw new CircuitException("500", "分账套餐总和不为1");
        }
        call_setShunterRules(banksn, rules);
    }

    protected void call_setShunterRules(String banksn, List<ShunterRuleBO> rules) throws CircuitException {
        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        Map<String, Object> args = new HashMap<>();
        args.put("rules", rules);
        String jsonArgs = new Gson().toJson(args);
        RequestBody requestBody = RequestBody.create(jsonArgs.getBytes());
        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "setShunterRules")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .post(requestBody)
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
    }

    @Override
    public void emptyShunterRules(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_emptyShunterRules(banksn);
    }

    protected void call_emptyShunterRules(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "emptyShunterRules")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
    }

    @Override
    public List<ShunterRuleBO> getShunterRules(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        return call_getShunterRules(banksn);
    }

    protected List<ShunterRuleBO> call_getShunterRules(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "getShunterRules")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<ShunterRuleBO>>() {
        }.getType());
    }

    @Override
    public List<TTMBO> getTTMTable(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        return call_getTTMTable(banksn);
    }

    protected List<TTMBO> call_getTTMTable(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "getTTMTable")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
        return new Gson().fromJson(json, new TypeToken<ArrayList<TTMBO>>() {
        }.getType());
    }

    @Override
    public void setTTMTable(ISecuritySession securitySession, String banksn, List<TTMBO> ttmTable) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_setTTMTable(banksn, ttmTable);
    }

    protected void call_setTTMTable(String banksn, List<TTMBO> ttmTable) throws CircuitException {
        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        Map<String, Object> args = new HashMap<>();
        args.put("ttmTable", ttmTable);
        RequestBody requestBody = RequestBody.create(new Gson().toJson(args).getBytes());
        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "setTTMTable")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .post(requestBody)
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
    }

    @Override
    public void emptyTTMTable(ISecuritySession securitySession, String banksn) throws CircuitException {
        demandAdminRights(securitySession);
        if (StringUtil.isEmpty(banksn)) {
            throw new CircuitException("404", "banksn 参数为空");
        }
        call_emptyTTMTable(banksn);
    }

    protected void call_emptyTTMTable(String banksn) throws CircuitException {

        OkHttpClient client = (OkHttpClient) site.getService("@.http");

        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsUrl = site.getProperty("ports.oc.wybank");
        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        final Request request = new Request.Builder()
                .url(String.format("%s?banksn=%s", portsUrl, banksn))
                .addHeader("Rest-Command", "emptyTTMTable")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
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
    }
}
