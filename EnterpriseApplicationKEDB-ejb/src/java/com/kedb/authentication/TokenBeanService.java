
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
