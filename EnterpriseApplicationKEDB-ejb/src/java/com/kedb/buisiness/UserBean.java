
package com.kedb.buisiness;

import com.kedb.entities.RoleEntity;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import com.kedb.persistence.UserDaoBeanService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class UserBean implements UserBeanService {

@EJB
private UserDaoBeanService userDao;

@EJB
private RoleBeanService roleBean;

    @Override
    public void createUser(String userName, RoleEntity role) {
        UserEntity userAux = new UserEntity();
        userAux.setUserName(userName);
        userAux.setRole(role);
        userDao.createUser(userAux);
      }
    
    @Override
    public void createUser(String userName, String userRole) throws ApplicationKEDBException{
        System.out.println("createUser recibiendo dos Strings");
        if(roleBean.getRole(userRole) != null){
            UserEntity userAux = new UserEntity();
            userAux.setUserName(userName);
            userAux.setRole(roleBean.getRole(userRole));
            userDao.createUser(userAux);
        }
    }

    @Override
    public void deleteUser(String userName) {
    }

    @Override
    public void modifyUser(String userName, UserEntity newUser) {
    }

    @Override
    public void findUser(String userName) {   
    }
    
    @Override
    public String getAllUsers() {
        return userDao.getAllUsers();
    }    
}
