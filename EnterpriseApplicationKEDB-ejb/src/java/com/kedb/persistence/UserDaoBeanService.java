/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import javax.ejb.Local;

/**
 *
 * @author gonzalo.martin
 */
@Local
public interface UserDaoBeanService {

    void deleteUser(UserEntity user);
    void modifyUser(UserEntity user);
    void createUser(UserEntity user);
    
}
