/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.logger.MessageLoggerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class UserDaoBean implements UserDaoBeanService {
    @PersistenceContext
    EntityManager em;

    @EJB
    private MessageLoggerLocal logger;
    
    @Override
    public void createUser(UserEntity user) {
        em.persist(user);
        logger.logInfo("Se agregó el usuario "+user.getUserName()+" con rol ");
        
    }
    
    @Override
    public void deleteUser(UserEntity user) {
        
        logger.logInfo("Se eliminó el usuario "+user.getUserName());
    }

    @Override
    public void modifyUser(UserEntity user) {
        
        logger.logInfo("Se modificó el usuario "+user.getUserName());        
    }

    @Override
    public UserEntity getUser(String id) {
        //select
        return null;
    }
    
    
}
