/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.UserBeanService;
import com.kedb.dtos.ResponseWebService;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import java.util.List;
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
import com.google.gson.Gson;

//@Stateless
//@LocalBean
@RequestScoped
@Path("/users")
public class UserWebService {
    
    @EJB
    private UserBeanService bLocal;
      
    @GET
    @Path("/listAllUsers")
    @Produces("application/json")
    public String getAllUsers() {
        Gson gson = new Gson();
        String ret = "";
        List<UserEntity> result = bLocal.getAllUsers();
        ret = gson.toJson(result);
        //System.out.println("OK");
        return ret;
    }
    
    @POST 
    @Path("/createUser")
    @Consumes("application/x-www-form-urlencoded")
    public ResponseWebService createUser(@FormParam("userName") String userName, @FormParam("userRole") String userRole) {
        ResponseWebService response = new ResponseWebService("");
        try{                    
            bLocal.createUser(userName, userRole);
            response.setMessage("Usuario " + userName +"creado ok.");
        }catch(ApplicationKEDBException e){
            //TODO:logger
            response.setMessage("Se ha producido un error. " + e.getMessage());
        }catch(Exception e){
           response.setMessage("Se ha producido un error " + e);          
        }
        return response;       
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
