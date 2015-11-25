
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UserDaoBeanService {

    void deleteUser(UserEntity user);
    void modifyUser(UserEntity user);
    void createUser(UserEntity user);
    UserEntity getUser(String id);
    String getAllUsers();
    
}
