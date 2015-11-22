/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.buisiness.KnowErrorBean;
import com.kedb.entities.KnowError;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author rolol
 */
@Stateless
public class KnowErrorDaoBean implements KnowErrorDao {
  @PersistenceContext
  EntityManager em;
  
    @Override
    public void createKnowError(KnowError knowError) {
        em.persist(knowError);
    //TODO: validaciones,logica de bd, try generico + try para cada uno de los métodos
        try {
        HttpSolrClient solr = new HttpSolrClient("http://localhost:8983/solr/kedb");                    
        SolrInputDocument document = new SolrInputDocument();
        document.addField("cause", knowError.getCause());
        document.addField("solution", knowError.getSolution());
        document.addField("workaround", knowError.getWorkaround());
        document.addField("category", knowError.getCategory()); 
        UpdateRequest req = new UpdateRequest();
        req.setAction( UpdateRequest.ACTION.COMMIT, false, false );
        req.add(document);
        UpdateResponse response = req.process(solr);
        System.out.println("RESPONSE " +response);
        solr.commit();  
        } catch (Exception ex){
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}