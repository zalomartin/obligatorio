
package com.kedb.buisiness;

import javax.ejb.Local;


@Local
public interface KnowErrorService {
    
    void createKnowError(String cause, String solution, String workaround, String category);
    String getKnowError(String category);
    String getKnowErrorKeyword(String keyword);
    String getKnowError();
    String getKnowErrorMySql(String category);
    String getKnowErrorMySql();
    String getKnowErrorKeywordMySql(String keyword);
}
