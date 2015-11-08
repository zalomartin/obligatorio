/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
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

    @Override
    public void createUser(UserEntity user) {
        UserEntity userEntity = null;
        //TODO:Falta validar que el usuario no exista
        userEntity = new UserEntity();
        UserEntity userNew = (UserEntity)user;
        userEntity.setUserName(userNew.getUserName());
        userEntity.setRole(userNew.getRole());
        em.persist(userEntity);
    }
    
    @Override
    public void deleteUser(UserEntity user) {
    }

    @Override
    public void modifyUser(UserEntity user) {
    }
    
}
