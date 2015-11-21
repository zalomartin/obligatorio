/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.KnowErrorService;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@RequestScoped
@Path("/ke")
public class KEWebService {
    
    @EJB
    private KnowErrorService bLocal;
    
    @POST 
    @Path("/createKE")
    @Consumes("application/x-www-form-urlencoded")
    public String createKE (@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category){    
     //  if (bLocal==null) return "error";
        System.out.println("-----------cause"+ cause);
        bLocal.createKnowError(cause, solution, workaround, category);
        return "OK";
    }
}

