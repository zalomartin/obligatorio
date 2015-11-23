/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;

/**
 *
 * @author gonzalo.martin
 */
@Local
public interface UserBeanService {

    void createUser(String userName, RoleEntity role);
    void createUser(String userName, String userRole) throws ApplicationKEDBException;
    void deleteUser(String userName);
    void modifyUser(String userName, UserEntity newUser);
    void findUser(String userName);

    
    
}
