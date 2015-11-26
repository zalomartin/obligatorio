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
        if(userName==null || userName.isEmpty() || role==null || role.isEmpty() || password==null || password.isEmpty()){
           throw new ApplicationKEDBException("Datos invalidos");
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
            }else{
                throw new ApplicationKEDBException("Rol no existe");
            }
        }else{
            throw new ApplicationKEDBException("Usuario ya ingresado");
        }
    }

    @Override
    public void deleteUser(String userName) {
    }

    @Override
    public void modifyUser(String userName, UserEntity newUser) {
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
