package com.kedb.validation;

import com.kedb.authentication.TokenBeanService;
import com.kedb.entities.KnowError;
import com.kedb.entities.UserEntity;
import com.kedb.enums.EnumRoles;
import com.kedb.exceptions.ApplicationKEDBException;
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
    private TokenBeanService tokenBeanService;

    @EJB
    private UserDaoBeanService userDaoBeanService;

    @Override
    public String createKnowError(String cause, String solution, String workaround, String category, String token, String userName) {
        String ret = "Unauthorized operation";
        try {
            if (cause == null || cause.isEmpty() || solution == null || solution.isEmpty() || workaround == null || workaround.isEmpty()
                    || category == null || category.isEmpty() || token == null || token.isEmpty() || userName == null || userName.isEmpty()) {

                throw new ApplicationKEDBException("Invalid input, required fields: cause, solution, workaround, category, token, userName");
            }
            if (tokenBeanService.validToken(token)) {
                UserEntity user = userDaoBeanService.getUser(userName);
                String userRol = user.getRole().getDescription().toUpperCase();
                String adminRol = EnumRoles.ADMINISTRATOR.toString();
                if (user != null && userRol.equals(adminRol)) {
                    KnowError knowErrorEntity = new KnowError();
                    knowErrorEntity.setCause(cause);
                    knowErrorEntity.setSolution(solution);
                    knowErrorEntity.setWorkaround(workaround);
                    knowErrorEntity.setCategory(category);
                    knowErrorEntity.setAuthor(user);
                    knowErrorDao.createKnowError(knowErrorEntity);
                    ret = "New Known Error created successfully.";
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
