/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.UserBeanService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


/**
 *
 * @author gonzalo.martin
 */
@Stateless
//@LocalBean
@Path("/users")
public class UserWebService {
    
    @EJB
    private UserBeanService bLocal;
    
    @GET
    @Produces("application/json")
    public void getAuthors() {
        System.out.println("OK");
    }
    
    @POST
 //   @Path("/createUser")
    @Consumes({"application/json", "application/x-www-form-urlencoded"})
    public void createUser(@QueryParam("userName") String userName) {
        System.out.println("-----------name"+ userName);
        bLocal.createUser(userName, null);
    }
    

}
