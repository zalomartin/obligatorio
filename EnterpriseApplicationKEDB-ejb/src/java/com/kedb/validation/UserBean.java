package com.kedb.validation;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import com.kedb.persistence.UserDaoBeanService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserBean implements UserBeanService {

    @EJB
    private UserDaoBeanService userDao;

    @EJB
    private RoleBeanService roleBean;

    @Override
    public void createUser(String userName, String role, String password) throws ApplicationKEDBException {
        if (userName == null || userName.isEmpty() || role == null || role.isEmpty() || password == null || password.isEmpty()) {
            throw new ApplicationKEDBException("\"Invalid input, required fields: userName, userRole, password");
        }
        UserEntity user = userDao.getUser(userName);
        if (user == null) {
            RoleEntity roleEntity = roleBean.getRole(role);
            if (roleEntity != null) {
                UserEntity userAux = new UserEntity();
                userAux.setUserName(userName);
                userAux.setPassword(password);
                userAux.setRole(roleEntity);
                userDao.createUser(userAux);
            } else {
                throw new ApplicationKEDBException("Role does not exist");
            }
        } else {
            String ret = suggestedUser(user);
            throw new ApplicationKEDBException("User already exists, suggested user " + ret);                
        }
    }
    
    @Override
    public void deleteUser(String userName) throws ApplicationKEDBException {
        if (userName == null || userName.isEmpty()) {
            throw new ApplicationKEDBException("\"Invalid input, required field: userName");
        }
        UserEntity user = userDao.getUser(userName);
        if (user != null) {
            //borrar usuario
            
        } else {
            throw new ApplicationKEDBException("User "+userName+ "does not exists");                
        }
    }
    
    //TODO agregar comentario
    public String suggestedUser(UserEntity user) throws ApplicationKEDBException{
        int i = 1;
        String userName = "";
        while (user != null){
            userName = user.getUserName()+String.valueOf(i);
            user = userDao.getUser(userName);
            i++;
        }
        return userName;
    }

    @Override
    public void modifyUser(String userName, UserEntity newUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UserEntity findUser(String userName) throws ApplicationKEDBException {
        return userDao.getUser(userName);
    }

    @Override
    public String getAllUsers() {
        return userDao.getAllUsers();
    }
}
