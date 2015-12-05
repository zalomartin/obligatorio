package com.kedb.validation;

import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;

@Local
public interface UserBeanService {

    public void createUser(String userName, String role, String password) throws ApplicationKEDBException;

    void deleteUser(String userName);

    void modifyUser(String userName, UserEntity newUser);

    public UserEntity findUser(String userName) throws ApplicationKEDBException;
    // List<UserEntity> getAllUsers();

    public String getAllUsers();

}
