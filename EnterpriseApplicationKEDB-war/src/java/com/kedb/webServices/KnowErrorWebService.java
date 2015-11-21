/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.KnowErrorService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
/**
 *
 * @author rololaaa y gonzalo martin
 */
//@Stateless
@RequestScoped
@Path("/knowError")
public class KnowErrorWebService {

@EJB
private KnowErrorService bLocal;

   @POST
   @Path("/createKE")
   @Consumes("application/x-www-form-urlencoded")
 //  @Consumes({"application/json", "application/x-www-form-urlencoded"})
    public void addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category) {
 //     public void addKnowError(@QueryParam("cause") String cause){  
        System.out.println("-----------cause"+ cause);
        bLocal.createKnowError(cause, solution, workaround, category);
    }
}