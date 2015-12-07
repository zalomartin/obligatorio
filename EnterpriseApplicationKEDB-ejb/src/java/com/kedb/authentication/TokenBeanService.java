/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.authentication;

import javax.ejb.Local;
import javax.security.auth.login.LoginException;

@Local
public interface TokenBeanService {

    public void logOutUser(String userName);

    public String getToken(String userName);

    public String issueToken(String userName) throws LoginException;

    public boolean validToken(String token);
}
