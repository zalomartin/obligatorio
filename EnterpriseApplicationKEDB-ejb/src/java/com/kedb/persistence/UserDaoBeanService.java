
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
