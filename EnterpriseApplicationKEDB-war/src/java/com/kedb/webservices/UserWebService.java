
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
    private UserBeanService bLocal;
      
    //Retorna la lista de usuarios
    @GET
    @Path("/listAllUsers")
    @Produces("application/json")
    public String getAllUsers() {
        //Gson gson = new Gson();
        String ret = "";
        ret = bLocal.getAllUsers();
     //   List<UserEntity> result = bLocal.getAllUsers();
     //   ret = gson.toJson(result);
        //System.out.println("OK");
        return ret;
    }
    
    @POST 
    @Path("/createUser")
    @Consumes("application/x-www-form-urlencoded")
    public ResponseWebService createUser(@FormParam("userName") String userName, @FormParam("userRole") String userRole, @FormParam("userPwd") String userPwd) throws ApplicationKEDBException {
        ResponseWebService response = new ResponseWebService("");
        try{                    
            bLocal.createUser(userName, userRole, userPwd);
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
