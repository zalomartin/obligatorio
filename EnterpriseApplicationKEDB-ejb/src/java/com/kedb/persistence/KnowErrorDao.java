
package com.kedb.persistence;

import com.kedb.entities.KnowError;
import javax.ejb.Local;


@Local
public interface KnowErrorDao {
    void createKnowError(KnowError knowError);
    String getKnowErrorSolr(String category);
    String getKnowErrorSolr();
    String getKnowErrorKeywordSolr(String keyword);
    String getKnowErrorMySql(String category);
    String getKnowErrorMySql();
    String getKnowErrorKeywordMySql(String keyword);
}
