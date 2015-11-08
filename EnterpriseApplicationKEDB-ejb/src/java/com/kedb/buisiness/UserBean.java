/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
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
    public void createUser(String userName, RoleEntity role) {
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setRole(role);
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(long id) {
    }

    @Override
    public void modifyUser(long id, String userName, RoleEntity role) {
    }

}
