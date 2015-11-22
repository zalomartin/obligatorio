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
        KnowError knowErrorEntity = null;
        knowErrorEntity = new KnowError();
        KnowError knowErrorNew = (KnowError)knowError;
        knowErrorEntity.setCause(knowErrorNew.getCause());
        knowErrorEntity.setSolution(knowErrorNew.getSolution());
        knowErrorEntity.setWorkaround(knowErrorNew.getWorkaround());
        knowErrorEntity.setCategory(knowErrorNew.getSolution());
        em.persist(knowErrorEntity);
    //TODO: validaciones,logica de bd, try generico + try para cada uno de los métodos
        //Insertamos en MySq
     /*   try {
        KnowError k = new KnowError();
        k.setCause(cause);
        k.setSolution(solution);
        k.setWorkaround(workaround);
        k.setCategory(category);
        em.persist(k);
        } catch (Exception ex){
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //Insertamos en Solr
        try {
        HttpSolrClient solr = new HttpSolrClient("http://localhost:8983/solr/kedb");                    
        SolrInputDocument document = new SolrInputDocument();
        document.addField("cause", knowErrorNew.getCause());
        document.addField("solution", knowErrorNew.getSolution());
        document.addField("workaround", knowErrorNew.getWorkaround());
        document.addField("category", knowErrorNew.getCategory()); 
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