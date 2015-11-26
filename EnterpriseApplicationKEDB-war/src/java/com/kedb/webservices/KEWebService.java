
package com.kedb.webservices;

import com.kedb.validation.KnowErrorService;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//@Stateless
@Stateful
@RequestScoped
@Path("/knowErrors")
public class KEWebService {

@EJB
private KnowErrorService bLocal2;

   @POST
   @Path("/createKEE")
   @Consumes("application/x-www-form-urlencoded")
   public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category) {
       if (bLocal2==null) return "error"; 
       System.out.println("-----------cause"+ cause);
       bLocal2.createKnowError(cause, solution, workaround, category);
       return "OK";
    }
}