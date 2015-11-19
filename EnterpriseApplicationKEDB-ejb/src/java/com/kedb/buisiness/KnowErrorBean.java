/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.KnowErrorDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;

import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author R
 */
@Stateless
public class KnowErrorBean implements KnowErrorService {

@EJB
private KnowErrorDao knowErrorDao;

    @Override
    public void createKnowError(String name) {
       
        try {
           
        HttpSolrClient solr = new HttpSolrClient("http://localhost:8983/solr/miBase");                    
        SolrInputDocument document = new SolrInputDocument();
        document.addField("name", name);
  
        UpdateRequest req = new UpdateRequest();
        req.setAction( UpdateRequest.ACTION.COMMIT, false, false );
        req.add( document );
        UpdateResponse response = req.process(solr);
        System.out.println(response);
       // solr.add(document);
        solr.commit();        
    } catch (Exception ex) {
        Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
    }          
         knowErrorDao.createKnowError(name);
    }         
 }


