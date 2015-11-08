/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.RoleDaoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class RoleBean implements RoleBeanService {
    
@EJB
private RoleDaoService roleDao;

    @Override
    public void createRole(String description) {
        roleDao.createRole(description);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void modifyRole(long id, String description) {
        roleDao.modifyRole(id, description);
    }
    
}