/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import java.util.List;
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
    UserEntity getUser(String id);
    public List<UserEntity> getAllUsers();
    
}
