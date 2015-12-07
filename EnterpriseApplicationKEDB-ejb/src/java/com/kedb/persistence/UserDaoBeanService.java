/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;

@Local
public interface UserDaoBeanService {

    void deleteUser(UserEntity user);

    void modifyUser(UserEntity user);

    void createUser(UserEntity user);

    UserEntity getUser(String userName) throws ApplicationKEDBException;

    String getAllUsers();
}
