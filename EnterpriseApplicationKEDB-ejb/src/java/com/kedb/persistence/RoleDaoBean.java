package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleDaoBean implements RoleDaoService {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createRole(String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modifyRole(long id, String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteRole(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RoleEntity getRole(String description) throws ApplicationKEDBException {
        RoleEntity roleAux = null;
        try {
            roleAux = em.createNamedQuery("RoleEntity.findRolName", RoleEntity.class)
                    .setParameter("description", description)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            Logger.getLogger(RoleDaoBean.class.getName()).log(Level.SEVERE, null, e);
            throw new ApplicationKEDBException("Error no manejado");
        }
        return roleAux;
    }
}
