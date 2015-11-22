/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.UserBeanService;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

//@Stateless
//@LocalBean
@RequestScoped
@Path("/users")
public class UserWebService {
    
    @EJB
    private UserBeanService bLocal;
    
    @GET
    @Path("listUsers")
    @Produces("application/json")
    public void getUsers() {
        System.out.println("OK");
    }
    
    @POST 
    @Path("/createUser")
    @Consumes("application/x-www-form-urlencoded")
    public String createUser(@FormParam("userName") String userName, @FormParam("userRole") String userRole) {
        if (bLocal==null) return "error";
        System.out.println("-----------Name "+ userName);
        System.out.println("-----------Role "+ userRole);
        bLocal.createUser(userName, userRole);
        return "OK";
    }
    
    @PUT
    @Path("/modifyUser")
    @Consumes("application/x-www-form-urlencoded")
    public String modifyUser(@FormParam("userName") String userName) {
        if (bLocal==null) return "error";
        System.out.println("-----------name"+ userName);
       // bLocal.createUser(userName, userRole);
        //bLocal.modifyUser(id, userName, null);
        return "OK";
    }
    
    @DELETE
    @Path("/deleteUser")
    @Consumes("application/x-www-form-urlencoded")
    public String deleteUser(@FormParam("userName") String userName) {
        if (bLocal==null) return "error";
        System.out.println("-----------name"+ userName);
        //bLocal.createUser(userName, null);
        //bLocal.deleteUser(id);
        return "OK";
    }
}
