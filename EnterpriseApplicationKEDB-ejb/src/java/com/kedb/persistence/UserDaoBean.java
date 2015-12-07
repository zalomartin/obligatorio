/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.google.gson.Gson;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import com.kedb.logger.MessageLoggerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDaoBean implements UserDaoBeanService {

    @PersistenceContext
    EntityManager em;

    @EJB
    private MessageLoggerLocal logger;

    @Override
    public void createUser(UserEntity user) {
        em.persist(user);
        logger.logInfo("New user " + user.getUserName() + " with role " + user.getRole().getDescription() + " was created");
    }

    @Override
    public void deleteUser(UserEntity user) {
        em.remove(user);
        logger.logInfo("User " + user.getUserName() + " with role " + user.getRole().getDescription() + " was deleted");
    }

    @Override
    public void modifyUser(UserEntity user) {
        logger.logInfo("User " + user.getUserName() + " with role " + user.getRole().getDescription() + " was modified");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UserEntity getUser(String userName) throws ApplicationKEDBException {
        UserEntity userAux = null;
        try {
            userAux = em.createNamedQuery("UserEntity.findUserByName", UserEntity.class)
                    .setParameter("userName", userName)
                    .getSingleResult();
        } catch (NoResultException e) {
            // logger.getLogger(UserDaoBean.class.getName()).log(Level.WARNING, null, e);
            return null;
        } catch (Exception e) {
            //  logger.getLogger(UserDaoBean.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            throw new ApplicationKEDBException("Error no manejado " + e.getMessage());
        }
        return userAux;
    }

    @Override
    public String getAllUsers() {
        List<UserEntity> userEntityAux = null;
        String ret = "";
        userEntityAux = em.createNamedQuery("UserEntity.getAllUsers", UserEntity.class).getResultList();
        Gson gson = new Gson();
        ret = gson.toJson(userEntityAux);
        return ret;
    }
}
