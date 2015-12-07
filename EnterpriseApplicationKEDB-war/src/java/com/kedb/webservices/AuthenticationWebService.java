/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webservices;

import com.kedb.authentication.AuthenticationBeanService;
import com.kedb.authentication.TokenBeanService;
import com.kedb.dtos.ResponseWebService;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.security.auth.login.LoginException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/authentication")
public class AuthenticationWebService {

    private static final long serialVersionUID = -6663599014192066936L;

    /* Dependency injection. */
    @EJB
    private AuthenticationBeanService autenticationBean;

    /* Authenticate the user using the credentials priveded, return an unique token. */
    @PermitAll
    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    public ResponseWebService login(@Context HttpHeaders httpHeaders, @FormParam("userName") String userName, @FormParam("userPwd") String userPass)
            throws LoginException {

        ResponseWebService response = new ResponseWebService("");
        try {
            if (userName == null || userName.isEmpty() || userPass == null || userPass.isEmpty()) {
                response.setMessage("Invalid input, required field: userName, userPass");
            }
            String responseBean = autenticationBean.autentication(userName, userPass);
            if (responseBean.equals("ERROR")) {
                response.setMessage("Invalid credentials");
            } else {
                response.setMessage("User " + userName + " authenticated successfully - Token " + responseBean);
            }
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        return response;
    }

    /* Logout the user into de system, return message confirmation. */
    @POST
    @Path("/logout")
    @Consumes("application/x-www-form-urlencoded")
    public ResponseWebService logOut(@Context HttpHeaders httpHeaders, @FormParam("username") String userName) throws LoginException {
        ResponseWebService response = new ResponseWebService("");
        String userNameAux = userName;
        try {
            if (userName == null || userName.isEmpty()) {
                response.setMessage("Invalid input, required field: userName");
            }
            autenticationBean.logOut(userName);
            response.setMessage("User " + userNameAux + " successfully logout");
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        return response;
    }
}
