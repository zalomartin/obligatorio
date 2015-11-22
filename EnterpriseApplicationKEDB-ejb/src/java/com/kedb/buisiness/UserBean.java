/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.persistence.UserDaoBeanService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class UserBean implements UserBeanService {

@EJB
private UserDaoBeanService userDao;

    @Override
    public void createUser(String userName, RoleEntity role) {
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setRole(role);
        userDao.createUser(user);
      /*  try {
        HttpSolrClient solr = new HttpSolrClient("http://localhost:8983/solr/kedb");                    
        SolrInputDocument document = new SolrInputDocument();
        document.addField("name", userName);  
        UpdateRequest req = new UpdateRequest();
        req.setAction( UpdateRequest.ACTION.COMMIT, false, false );
        req.add(document);
        UpdateResponse response;
        response = req.process(solr);
        System.out.println("RESPONSE " +response);
        solr.commit(); 
          } catch (SolrServerException ex) {
        Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void deleteUser(long id) {
    }

    @Override
    public void modifyUser(long id, String userName, RoleEntity role) {
    }

    @Override
    public void findUser(long id) {
    }
    
    

}
