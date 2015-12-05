/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webservices;

import com.kedb.authentication.AuthenticationBeanService;
import com.kedb.authentication.TokenBeanService;
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

    @EJB
    private AuthenticationBeanService autenticationBean;

    @PermitAll
    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    public Response login(
            @Context HttpHeaders httpHeaders,
            @FormParam("username") String userName,
            @FormParam("password") String password) throws LoginException {

        try {
            System.out.println(userName + " " + password);
            // Authenticate the user using the credentials provided            
            String responseBean = autenticationBean.autentication(userName, password);
            if (responseBean.equals("ERROR")) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            } else {
                return Response.ok("ok " + responseBean).build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Response.status(Response.Status.UNAUTHORIZED);
        }
        return null;
    }

    @POST
    @Path("/logOut")
    @Consumes("application/x-www-form-urlencoded")
    public Response logOut(
            @Context HttpHeaders httpHeaders,
            @FormParam("username") String userName) throws LoginException {

        try {
            autenticationBean.logOut(userName);
            return Response.ok("User " + userName + "logut ok").build();
        } catch (Exception ex) {
            ex.printStackTrace();
            Response.status(Response.Status.UNAUTHORIZED);
        }
        return null;
    }
}
