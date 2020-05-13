package cj.netos.gateway.wybank;

import cj.studio.openport.CheckAccessTokenException;

import java.util.Map;

public interface IPersonService {
    Map<String,Object> getPersonInfo(String accessToken) throws CheckAccessTokenException;
}
