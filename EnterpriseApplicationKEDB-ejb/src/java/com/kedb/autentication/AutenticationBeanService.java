/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.autentication;

import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

/**
 *
 * @author gonzalom
 */
@Local
public interface AutenticationBeanService {
    public String autentication(String userName, String password ) throws ApplicationKEDBException;
}
