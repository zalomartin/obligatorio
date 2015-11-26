
package com.kedb.webservices;

import com.kedb.validation.KnowErrorBeanService;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateful
@RequestScoped
@Path("/knowErrors")
public class KEWebService {

@EJB
private KnowErrorBeanService knowErrorBeanService;

   @POST
   @Path("/createKEE")
   @Consumes("application/x-www-form-urlencoded")
   public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category, @FormParam("token") String token) {
       if (knowErrorBeanService==null) return "error"; 
       System.out.println("-----------cause"+ cause);
       knowErrorBeanService.createKnowError(cause, solution, workaround, category, token);
       return "OK";
    }
}