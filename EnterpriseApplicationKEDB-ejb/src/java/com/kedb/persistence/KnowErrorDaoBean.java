package com.kedb.persistence;

import com.google.gson.Gson;
import com.kedb.configurations.Configuration;
import com.kedb.entities.KnowError;
import com.kedb.messageProducer.MessageProducerBeanLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.noggit.JSONUtil;

@Stateless
public class KnowErrorDaoBean implements KnowErrorDao {

    @PersistenceContext
    EntityManager em;

    @EJB
    private MessageProducerBeanLocal mdb;

    @Override
    public void createKnowError(KnowError knowError) {
        em.persist(knowError);
        //TODO: validaciones,logica de bd, try generico + try para cada uno de los métodos
        try {
            String solrPath = Configuration.getString("solr.path");
            HttpSolrClient solr = new HttpSolrClient(solrPath);
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", knowError.getId());
            document.addField("cause", knowError.getCause());
            document.addField("solution", knowError.getSolution());
            document.addField("workaround", knowError.getWorkaround());
            document.addField("category", knowError.getCategory());
            UpdateRequest req = new UpdateRequest();
            req.setAction(UpdateRequest.ACTION.COMMIT, false, false);
            req.add(document);
            UpdateResponse response = req.process(solr);
            solr.commit();
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorDaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        mdb.theMessage("Se registro un nuevo KE");
    }

    @Override
    public String getKnowErrorSolr(String category) {
        String ret = "";
        String cat = category;
        try {
            String solrPath = Configuration.getString("solr.path");
            HttpSolrClient client = new HttpSolrClient(solrPath);
            client.setUseMultiPartPost(true);
            client.setConnectionTimeout(5000);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery(cat);
            solrQuery.setFields("ID", "CATEGORY", "CAUSE", "SOLUTION", "WORKAROUND");
            solrQuery.setStart(0);
            solrQuery.setRows(200);
            QueryResponse response = client.query(solrQuery);
            SolrDocumentList results = response.getResults();
            ret = JSONUtil.toJSON(results); //this has the json documents
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorDaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public String getKnowErrorKeywordSolr(String keyword) {
        String ret = "";
        String key = keyword;
        try {
            String solrPath = Configuration.getString("solr.path");
            HttpSolrClient client = new HttpSolrClient(solrPath);
            client.setUseMultiPartPost(true);
            client.setConnectionTimeout(5000);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery(key);
            solrQuery.setFields("ID", "CATEGORY", "CAUSE", "SOLUTION", "WORKAROUND");
            solrQuery.setStart(0);
            solrQuery.setRows(200);
            QueryResponse response = client.query(solrQuery);
            SolrDocumentList results = response.getResults();
            ret = JSONUtil.toJSON(results); //this has the json documents
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorDaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public String getKnowErrorSolr() {
        String ret = "";
        try {
            String solrPath = Configuration.getString("solr.path");
            HttpSolrClient client = new HttpSolrClient(solrPath);
            client.setUseMultiPartPost(true);
            client.setConnectionTimeout(5000);
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            solrQuery.setFields("ID", "CATEGORY", "CAUSE", "SOLUTION", "WORKAROUND");
            solrQuery.setStart(0);
            solrQuery.setRows(25000);
            QueryResponse response = client.query(solrQuery);
            SolrDocumentList results = response.getResults();
            ret = JSONUtil.toJSON(results); //this has the json documents
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorDaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public String getKnowErrorMySql(String category) {
        List<KnowError> knowErrorAux = null;
        String ret = "";
        knowErrorAux = em.createNamedQuery("KnowError.getKECategory", KnowError.class).setParameter("category", category).getResultList();
        Gson gson = new Gson();
        ret = gson.toJson(knowErrorAux);
        return ret;
    }

    @Override
    public String getKnowErrorKeywordMySql(String keyword) {
        List<KnowError> knowErrorAux = null;
        String ret = "";
        knowErrorAux = em.createNamedQuery("KnowError.getKEKeyword", KnowError.class).setParameter("cause", keyword).setParameter("category", keyword).setParameter("workaround", keyword).setParameter("solution", keyword).getResultList();
        Gson gson = new Gson();
        ret = gson.toJson(knowErrorAux);
        return ret;
    }

    @Override
    public String getKnowErrorMySql() {
        List<KnowError> knowErrorAux = null;
        String ret = "";
        knowErrorAux = em.createNamedQuery("KnowError.getAllKE", KnowError.class).getResultList();
        Gson gson = new Gson();
        ret = gson.toJson(knowErrorAux);
        return ret;
    }
}
