/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.webservices;

import com.google.gson.Gson;
import com.kedb.dtos.ResponseWebService;
import com.kedb.exceptions.ApplicationKEDBException;
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

    /* Dependency injection. */
    @EJB
    private KnowErrorBeanService knowErrorBeanService;

    /* Creation of a new Known Error. */
    @POST
    @Path("/createKE")
    @Consumes("application/x-www-form-urlencoded")
    public String addKnowError(@FormParam("cause") String cause, @FormParam("solution") String solution, @FormParam("workaround") String workaround,
            @FormParam("category") String category, @FormParam("token") String token, @FormParam("userName") String userName)
            throws ApplicationKEDBException {

        ResponseWebService response = new ResponseWebService("");
        try {
            if (cause == null || cause.isEmpty() || solution == null || solution.isEmpty() || workaround == null || workaround.isEmpty()
                    || category == null || category.isEmpty() || token == null || token.isEmpty() || userName == null || userName.isEmpty()) {
                response.setMessage("Invalid input, required fields: cause, solution, workaround, category, token, userName");
            } else {
                response.setMessage(knowErrorBeanService.createKnowError(cause, solution, workaround, category, token, userName));
            }
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from Solr. */
    @GET
    @Path("/listAllKE")
    @Produces("application/json")
    public String getAllKE() {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowError();
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from Solr matched with an specific category. */
    @GET
    @Path("/listKECategory")
    @Produces("application/json")
    public String getKnowErrorCategory(@QueryParam("category") String category) {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowError(category);
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from Solr matched with an specific keyword. */
    @GET
    @Path("/listKEByKeyword")
    @Produces("application/json")
    public String getKnowErrorKeyword(@QueryParam("keyword") String keyword) {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowErrorKeyword(keyword);
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from MySQL. */
    @GET
    @Path("/listAllKEMySql")
    @Produces("application/json")
    public String getAllKEMySql() {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowErrorMySql();
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from MySQL matched with an specific keyword. */
    @GET
    @Path("/listKEKeywordMySql")
    @Produces("application/json")
    public String getKnowErrorKeywordMySql(@QueryParam("keyword") String keyword) {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowErrorKeywordMySql(keyword);
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    /* List all Known Error from MySQL matched with an specific category. */
    @GET
    @Path("/listKECategoryMySql")
    @Produces("application/json")
    public String getKnowErrorCategoryMySql(@QueryParam("category") String category) {
        ResponseWebService response = new ResponseWebService("");
        try {
            return knowErrorBeanService.getKnowErrorMySql(category);
        } catch (Exception e) {
            response.setMessage("" + e);
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
