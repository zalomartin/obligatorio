/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.KnowErrorService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
/**
 *
 * @author rololaaa probano
 */
@Stateless
@Path("/knowError")
public class KnowErrorWebService {

@EJB
private KnowErrorService bLocal;

   @POST
   @Consumes({"application/json", "application/x-www-form-urlencoded"})
 // @Consumes(MediaType.APPLICATION_JSON)
    public void addKnowError(@QueryParam("name") String name) {
       //TODO: remove
        System.out.println("-----------nombre"+ name);
        bLocal.createKnowError(name);
    }
}