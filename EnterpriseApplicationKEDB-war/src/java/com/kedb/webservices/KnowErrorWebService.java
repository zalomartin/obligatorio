package com.kedb.webservices;

import com.kedb.validation.KnowErrorBeanService;
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
    private KnowErrorBeanService knowErrorBeanService;

    //CREACIÓN DE UN NUEVO KNOW ERROR 

    @POST
    @Path("/createKE")
    @Consumes("application/x-www-form-urlencoded")
    public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround, @FormParam("category") String category, @FormParam("token") String token, @FormParam("userName") String userName) {

        if (cause == null || cause.isEmpty() || solution == null || solution.isEmpty() || workaround == null || workaround.isEmpty() || category == null || category.isEmpty() || token == null || token.isEmpty() || userName == null || userName.isEmpty()) {
            return ("Invalid Input, required fields: cause, solution, workaround, category, token, userName");
        }

        String ret = knowErrorBeanService.createKnowError(cause, solution, workaround, category, token, userName);
        if (ret != null && ret != "OK") {
            return ret;
        } else {
            return "OK";
        }
    }

    //*******************************
    //RETORNO DE KNOW ERRORS EN SOLR
    //*******************************
    //RETORNA TODOS LOS KNOW ERRORS
    @GET
    @Path("/getAllKE")
    @Produces("application/json")
    public String getAllKE() {
        return knowErrorBeanService.getKnowError();
    }

    //RETORNA KNOW ERRORS FILTRADOS POR UNA CATEGORIA
    @GET
    @Path("/getKECategory")
    @Produces("application/json")
    public String getKnowErrorCategory(@QueryParam("category") String category) {
        return knowErrorBeanService.getKnowError(category);
    }

    //Retorna los KnowErrors filtrados por la palabra clave ingresada
    @GET
    @Path("/getKEKeyword")
    @Produces("application/json")
    public String getKnowErrorKeyword(@QueryParam("keyword") String keyword) {
        return knowErrorBeanService.getKnowErrorKeyword(keyword);
    }

    //*******************************
    //RETORNO DE KNOW ERRORS EN MYSQL
    //*******************************
    @GET
    @Path("/getAllKEMySql")
    @Produces("application/json")
    public String getAllKEMySql() {
        return knowErrorBeanService.getKnowErrorMySql();
    }

    //Retorna los KnowErrors filtrados por la palabra clave ingresada en la BD MySql
    @GET
    @Path("/getKEKeywordMySql")
    @Produces("application/json")
    public String getKnowErrorKeywordMySql(@QueryParam("keyword") String keyword) {
        return knowErrorBeanService.getKnowErrorKeywordMySql(keyword);
    }

    //Retorna los KnowErrors filtrados por la categoría que se ingreso de la BD MySql
    @GET
    @Path("/getKECategoryMySql")
    @Produces("application/json")
    public String getKnowErrorCategoryMySql(@QueryParam("category") String category) {
        return knowErrorBeanService.getKnowErrorMySql(category);
    }
}
