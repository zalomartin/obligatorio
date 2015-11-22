/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.KnowError;
import com.kedb.persistence.KnowErrorDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;

import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;


@Stateless
public class KnowErrorBean implements KnowErrorService {

@EJB
private KnowErrorDao knowErrorDao;

    @Override
    public void createKnowError(String cause, String solution, String workaround, String category) {
        System.out.println("llego");
        try {   
            KnowError knowErrorEntity = new KnowError();
            knowErrorEntity.setCause(cause);
            knowErrorEntity.setSolution(solution);
            knowErrorEntity.setWorkaround(workaround);
            knowErrorEntity.setCategory(category);
            knowErrorDao.createKnowError(knowErrorEntity);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }          
    }    

    @Override
    public void findKnowError() {  
        try { 
        HttpSolrClient client = new HttpSolrClient("http://localhost:8983/solr/kedb");
        client.setUseMultiPartPost(true);
        client.setConnectionTimeout(5000);
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("change.me");
        solrQuery.setFields("id");
        solrQuery.setStart(0);
        solrQuery.setRows(10);
        QueryResponse response = client.query(solrQuery);
        SolrDocumentList results = response.getResults();
        for (int i = 0; i < results.size(); ++i) {
            System.out.println(results.get(i));
        }
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }   
 }


