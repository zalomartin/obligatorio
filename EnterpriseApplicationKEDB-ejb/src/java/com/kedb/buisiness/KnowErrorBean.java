
package com.kedb.buisiness;

import com.kedb.entities.KnowError;
import com.kedb.persistence.KnowErrorDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class KnowErrorBean implements KnowErrorService {

@EJB
private KnowErrorDao knowErrorDao;

    @Override
    public void createKnowError(String cause, String solution, String workaround, String category) {
        try {   
            KnowError knowErrorEntity = new KnowError();
            knowErrorEntity.setCause(cause);
            knowErrorEntity.setSolution(solution);
            knowErrorEntity.setWorkaround(workaround);
            knowErrorEntity.setCategory(category);
            knowErrorDao.createKnowError(knowErrorEntity);
        } catch (Exception ex) {
            Logger.getLogger(KnowErrorBean.class.getName()).log(Level.SEVERE, null, ex);    
        }          
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


