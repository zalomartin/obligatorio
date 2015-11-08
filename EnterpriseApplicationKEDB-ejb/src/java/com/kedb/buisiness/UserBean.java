/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.Role;
import com.kedb.persistence.UserDaoBeanService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class UserBean implements UserBeanService {

@EJB
private UserDaoBeanService userDao;

    @Override
    public void createUser(String userName, Role role) {
        userDao.createUser(userName, role);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void modifyUser(long id, String userName, Role role) {
        userDao.modifyUser(id, userName, role);
    }

}
