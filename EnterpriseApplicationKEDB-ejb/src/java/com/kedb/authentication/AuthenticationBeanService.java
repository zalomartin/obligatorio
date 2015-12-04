
package com.kedb.authentication;

import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;


@Local
public interface AuthenticationBeanService {
    public String autentication(String userName, String password ) throws ApplicationKEDBException;
    public void logOut(String userName);
}
