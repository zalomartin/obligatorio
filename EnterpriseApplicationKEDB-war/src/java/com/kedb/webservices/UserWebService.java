
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
      
    //Retorna la lista de usuarios
    @GET
    @Path("/listAllUsers")
    @Produces("application/json")
    public String getAllUsers() {
        return userBeanService.getAllUsers();
    }
    
    @POST 
    @Path("/createUser")
    @Consumes("application/x-www-form-urlencoded")
    public ResponseWebService createUser(@FormParam("userName") String userName, @FormParam("userRole") String userRole, @FormParam("userPwd") String userPwd) throws ApplicationKEDBException {
        ResponseWebService response = new ResponseWebService("");
        try{                    
            if(userName==null || userName.isEmpty() || userRole==null || userRole.isEmpty() || userPwd==null || userPwd.isEmpty()){
              response.setMessage("Invalid Input, required fields: userName, userRole, userPwd");
            }
            userBeanService.createUser(userName, userRole, userPwd);
            response.setMessage("Usuario " + userName +" creado ok.");
        }catch(Exception e){
            response.setMessage("Se ha producido un error " + e);          
        }
        return response;       
    }
    
    @PUT
    @Path("/modifyUser")
    @Consumes("application/x-www-form-urlencoded")
    public String modifyUser(@FormParam("userName") String userName) {
        return "Not supported yet.";
    }
    
    @DELETE
    @Path("/deleteUser")
    @Consumes("application/x-www-form-urlencoded")
    public String deleteUser(@FormParam("userName") String userName) {
        return "Not supported yet.";
    }
}
