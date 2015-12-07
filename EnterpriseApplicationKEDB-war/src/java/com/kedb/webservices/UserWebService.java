/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webservices;

import com.kedb.validation.UserBeanService;
import com.kedb.dtos.ResponseWebService;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("/users")
public class UserWebService {

    @EJB
    private UserBeanService userBeanService;

    /* List all users from MySQL. */
    @GET
    @Path("/listAllUsers")
    @Produces("application/json")
    public String getAllUsers() {
        return userBeanService.getAllUsers();
    }

    /* Create a new user account. */
    @POST
    @Path("/createUser")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public ResponseWebService createUser(@FormParam("userName") String userName, @FormParam("userRole") String userRole, @FormParam("userPwd") 
            String userPwd) throws ApplicationKEDBException {
        
        ResponseWebService response = new ResponseWebService("");
        try {
            if (userName == null || userName.isEmpty() || userRole == null || userRole.isEmpty() || userPwd == null || userPwd.isEmpty()) {
                response.setMessage("Invalid input, required fields: userName, userRole, userPwd");
            }
            userBeanService.createUser(userName, userRole.toUpperCase(), userPwd);
            response.setMessage("Account user " + userName + " created successfully.");
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        return response;
    }

    /* Modify user account. */
    @PUT
    @Path("/modifyUser")
    @Consumes("application/x-www-form-urlencoded")
    public String modifyUser(@FormParam("userName") String userName) {
        return "Not supported yet.";
    }

    /* Delete user account. */
    @DELETE
    @Path("/deleteUser")
    @Produces("application/json")
    public ResponseWebService deleteUser(@FormParam("userName") String userName) throws ApplicationKEDBException {
        ResponseWebService response = new ResponseWebService("");
        try {
            if (userName == null || userName.isEmpty()) {
                response.setMessage("Invalid input, required field: userName");
            }
            userBeanService.deleteUser(userName);
            response.setMessage("Account user " + userName + " deleted successfully.");
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        return response;
    }
}
