
package com.kedb.authentication;

import com.kedb.validation.UserBeanService;
import com.kedb.entities.UserEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AuthenticationBean implements AuthenticationBeanService {

    @EJB
    private TokenBeanService systemBean;

    @EJB
    private UserBeanService userBean;

    @Override
    public String autentication(String userName, String password) throws ApplicationKEDBException {
        try {
            String ret= "ERROR";        
            String token = systemBean.getToken(userName);
            //Return the token on the response       
            if(token!=null){
                ret = token;            
            }else{            
            // Authenticate the user using the credentials provided
            UserEntity user = userBean.findUser(userName);
            if (user != null) {
               String userNameBD = user.getUserName();
               String pwdBD = user.getPassword();   
               //TODO:hacer de otra forma en una clase util o similar
               String pwd = user.encriptPassword(password);
               if (userName.equals(userNameBD) && pwd.equals(pwdBD)) {
                   ret = systemBean.issueToken(userName);
               }
             }
            }                
           return ret;                    
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationKEDBException("Error en autenticacion" + e.getMessage());
        }
    }

    @Override
    public void logOut(String userName) {      
        systemBean.logOutUser(userName);
    }
}
