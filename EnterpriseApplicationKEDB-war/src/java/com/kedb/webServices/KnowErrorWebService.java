/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.KnowErrorService;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


//@WebService(serviceName = "KnowErrorWebService")
@RequestScoped
@Path("/knowError")
public class KnowErrorWebService {

@EJB
private KnowErrorService bLocal;

   @POST
   @Path("/createKE")
   @Consumes("application/x-www-form-urlencoded") 
   public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category) {
      if (bLocal==null) return "error";
       System.out.println("-----------cause"+ cause);
       bLocal.createKnowError(cause, solution, workaround, category);
       return "OK";
    }
   
}
