
package com.kedb.validation;

import javax.ejb.Local;


@Local
public interface KnowErrorBeanService {
    
    public String createKnowError(String cause, String solution, String workaround, String category, String token);
    String getKnowError(String category);
    String getKnowErrorKeyword(String keyword);
    String getKnowError();
    String getKnowErrorMySql(String category);
    String getKnowErrorMySql();
    String getKnowErrorKeywordMySql(String keyword);    
}
