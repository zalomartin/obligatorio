/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class RoleDaoBean implements RoleDaoService {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void createRole(String description) {
    }

    @Override
    public void modifyRole(long id, String description) {
    }

    @Override
    public void deleteRole(long id) {
    }

    /**
     *
     * @param description
     * @return
     * @throws ApplicationKEDBException
     */
    @Override
    public RoleEntity getRole(String description) throws ApplicationKEDBException{
        RoleEntity roleAux = null;
        try {
             roleAux = em.createNamedQuery("RoleEntity.findRolName",RoleEntity.class)
                    .setParameter("description", description)
                    .getSingleResult();    
        }catch(NoResultException e){
           Logger.getLogger(RoleDaoBean.class.getName()).log(Level.SEVERE, null, e);
           throw new ApplicationKEDBException("El rol no existe");
        }      
        return roleAux;
    }
}
