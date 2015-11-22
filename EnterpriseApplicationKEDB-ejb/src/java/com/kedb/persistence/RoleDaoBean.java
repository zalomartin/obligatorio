/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    @Override
    public RoleEntity getRole(String description) {
        System.out.println("Llego al getRole de RoleDao");
        RoleEntity roleAux = (RoleEntity)em.createQuery("select m from RoleEntity m where m.description=:description").setParameter("description", description).getSingleResult();
                
        System.out.println("Obtengo el role de la base");
        if (roleAux==null){
              System.out.println("No se encontro una usuario con ese identificador");
              return null;
         }
        return roleAux;
    }
    
    
    
}
