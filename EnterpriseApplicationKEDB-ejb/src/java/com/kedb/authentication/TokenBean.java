package com.kedb.authentication;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Startup;
import javax.security.auth.login.LoginException;

@Startup
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)

public class TokenBean implements TokenBeanService {

    private Map<String, String> serviceUsersKeysStorage = new HashMap();

    @Override
    @Lock(LockType.WRITE)
    public void logOutUser(String userName) {
        if (this.serviceUsersKeysStorage.containsKey(userName)) {
            this.serviceUsersKeysStorage.remove(userName);
        }
    }

    @Override
    @Lock(LockType.READ)
    public String getToken(String userName) {
        return this.serviceUsersKeysStorage.get(userName);
    }

    //TODO: validar que no exista una entrada con ese token

    @Override
    @Lock(LockType.WRITE)
    public String issueToken(String userName) throws LoginException {
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        this.serviceUsersKeysStorage.put(userName, token);
        return token;
    }

    @Override
    public boolean validToken(String token) {
        return this.serviceUsersKeysStorage.containsValue(token);
    }
}
