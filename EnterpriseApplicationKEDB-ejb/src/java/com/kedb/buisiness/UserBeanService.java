/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.entities.Role;
import javax.ejb.Local;

/**
 *
 * @author gonzalo.martin
 */
@Local
public interface UserBeanService {

    void createUser(String userName, Role role);
    void deleteUser(long id);
    void modifyUser(long id, String userName, Role role);
    
}
