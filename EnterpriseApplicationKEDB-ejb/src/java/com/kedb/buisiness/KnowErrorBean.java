/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.KnowErrorDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.CursorMarkParams;

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
        HttpSolrClient solr = new HttpSolrClient("http://localhost:8983/solr/kedb");                    
        SolrInputDocument document = new SolrInputDocument();
        document.addField("name", name);  
        UpdateRequest req = new UpdateRequest();
        req.setAction( UpdateRequest.ACTION.COMMIT, false, false );
        req.add(document);
        UpdateResponse response = req.process(solr);
        System.out.println("RESPONSE " +response);
        solr.commit();              
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }          
      //   knowErrorDao.createKnowError(name);
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


