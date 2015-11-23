/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webServices;

import com.kedb.buisiness.KnowErrorService;
import com.sun.faces.action.RequestMapping;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@RequestScoped
@Path("/knowError")
public class KnowErrorWebService {

    @EJB
    private KnowErrorService bLocal;

    //Crea un nuevo KnowError
    @POST
    @Path("/createKE")
    @Consumes("application/x-www-form-urlencoded")
    public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category) {
        if (bLocal == null) {
            return "error";
        }
        System.out.println("-----------cause" + cause);
        bLocal.createKnowError(cause, solution, workaround, category);
        return "OK";
    }

    //Retorna todos los KnowErrors de la BD Solr
    @GET
    @Path("/getAllKE")
    @Produces("application/json")
    public String getAllKE() {
        String ret = "";
        ret = bLocal.getKnowError();
        return ret;
    }

    //Retorna todos los KnowErrors de la BD MySql
    @GET
    @Path("/getAllKEMySql")
    @Produces("application/json")
    public String getAllKEMySql() {
        String ret = "";
        ret = bLocal.getKnowErrorMySql();
        return ret;
    }
    
    //Retorna los KnowErrors filtrados por la categoría que se ingreso de la BD Solr
    @GET
    @Path("/getKECategory")
    @Produces("application/json")
    public String getKnowErrorCategory(@QueryParam("category") String category) {
        String ret = "";
        ret = bLocal.getKnowError(category);
        return ret;
    }

    //Retorna los KnowErrors filtrados por la categoría que se ingreso de la BD MySql
    @GET
    @Path("/getKECategoryMySql")
    @Produces("application/json")
    public String getKnowErrorCategoryMySql(@QueryParam("category") String category) {
        String ret = "";
        ret = bLocal.getKnowErrorMySql(category);
        return ret;
    }
    
    //Retorna los KnowErrors filtrados por la palabra clave ingresada
    //TODO:No funciona
    @GET
    @Path("/getKEKeyword")
    @Produces("application/json")
    public String getKnowErrorKeyword(@QueryParam("keyword") String keyword) {
        String ret = "";
        ret = bLocal.getKnowErrorKeyword(keyword);
        return ret;
    }
}
