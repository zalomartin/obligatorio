
package com.kedb.validation;

import com.kedb.autentication.SystemBeanService;
import com.kedb.entities.KnowError;
import com.kedb.entities.UserEntity;
import com.kedb.enums.EnumRoles;
import com.kedb.persistence.KnowErrorDao;
import com.kedb.persistence.UserDaoBeanService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class KnowErrorBean implements KnowErrorBeanService {

@EJB
private KnowErrorDao knowErrorDao;

@EJB 
private SystemBeanService systemBeanService;

@EJB
private UserDaoBeanService userDaoBeanService;

    @Override
    public String createKnowError(String cause, String solution, String workaround, String category, String token, String userName) {
        String ret = "unauthorized operation";
        try {   
            if(systemBeanService.validToken(token))
            {                
               UserEntity user =  userDaoBeanService.getUser(userName);
               String userRol = user.getRole().getDescription().toUpperCase();
               String adminRol = EnumRoles.ADMIN.toString();
               if(user!=null && userRol.equals(adminRol)){
                    KnowError knowErrorEntity = new KnowError();
                    knowErrorEntity.setCause(cause);
                    knowErrorEntity.setSolution(solution);
                    knowErrorEntity.setWorkaround(workaround);
                    knowErrorEntity.setCategory(category);
                    knowErrorDao.createKnowError(knowErrorEntity);
                    ret = "OK";
                }
            }            
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }          
        return ret;
    }    

    @Override
    public String getKnowError(String category) {  
        String ret = "";
        try {
            ret = knowErrorDao.getKnowErrorSolr(category);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }
    
    @Override
    public String getKnowErrorKeyword(String keyword) {  
        String ret = "";
        try {
            ret = knowErrorDao.getKnowErrorKeywordSolr(keyword);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }
    
    //Retorno todos los Know Errors
    @Override
    public String getKnowError() {  
        String ret = "";
        try {
            ret = knowErrorDao.getKnowErrorSolr();
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }  

    @Override
    public String getKnowErrorMySql(String category) {
        String ret = "";
        ret = category;
        try {
            ret = knowErrorDao.getKnowErrorMySql(ret);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }
    
    @Override
    public String getKnowErrorKeywordMySql(String keyword) {
        String ret = "";
        ret = keyword;
        try {
            ret = knowErrorDao.getKnowErrorKeywordMySql(keyword);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }
    
    @Override
    public String getKnowErrorMySql() {
        String ret = "";
        try {
            ret = knowErrorDao.getKnowErrorMySql();
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return ret;
    }
}


