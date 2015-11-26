
package com.kedb.webservices;

import com.kedb.validation.KnowErrorService;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
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
    
    //CREACIÓN DE UN NUEVO KNOW ERROR 
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
    
    //*******************************
    //RETORNO DE KNOW ERRORS EN SOLR
    //*******************************
    
    //RETORNA TODOS LOS KNOW ERRORS
    @GET
    @Path("/getAllKE")
    @Produces("application/json")
    public String getAllKE() {
        String ret = "";
        ret = bLocal.getKnowError();
        return ret;
    }
    
    //RETORNA KNOW ERRORS FILTRADOS POR UNA CATEGORIA
    @GET
    @Path("/getKECategory")
    @Produces("application/json")
    public String getKnowErrorCategory(@QueryParam("category") String category) {
        String ret = "";
        ret = bLocal.getKnowError(category);
        return ret;
    }
    
    //Retorna los KnowErrors filtrados por la palabra clave ingresada
    @GET
    @Path("/getKEKeyword")
    @Produces("application/json")
    public String getKnowErrorKeyword(@QueryParam("keyword") String keyword) {
        String ret = "";
        ret = bLocal.getKnowErrorKeyword(keyword);
        return ret;
    }

    //*******************************
    //RETORNO DE KNOW ERRORS EN MYSQL
    //*******************************
    
    @GET
    @Path("/getAllKEMySql")
    @Produces("application/json")
    public String getAllKEMySql() {
        String ret = "";
        ret = bLocal.getKnowErrorMySql();
        return ret;
    }
    
    //Retorna los KnowErrors filtrados por la palabra clave ingresada en la BD MySql
    @GET
    @Path("/getKEKeywordMySql")
    @Produces("application/json")
    public String getKnowErrorKeywordMySql(@QueryParam("keyword") String keyword) {
        String ret = "";
        ret = bLocal.getKnowErrorKeywordMySql(keyword);
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
}
