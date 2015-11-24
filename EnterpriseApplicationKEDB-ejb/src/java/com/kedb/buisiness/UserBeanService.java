
package com.kedb.buisiness;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UserBeanService {

    void createUser(String userName, RoleEntity role);
    void createUser(String userName, String userRole) throws ApplicationKEDBException;
    void deleteUser(String userName);
    void modifyUser(String userName, UserEntity newUser);
    void findUser(String userName);
    List<UserEntity> getAllUsers();
    
}
