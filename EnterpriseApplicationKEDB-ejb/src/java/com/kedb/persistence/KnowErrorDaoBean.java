/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.KnowErrorEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rolol
 */
@Stateless
public class KnowErrorDaoBean implements KnowErrorDao {
  @PersistenceContext
  EntityManager em;
  
    @Override
    public void createKnowError(String name) {
        //TODO: validaciones,logica de bd
        KnowErrorEntity k = new KnowErrorEntity();
        k.setName(name);
        em.persist(k);
    }
}
