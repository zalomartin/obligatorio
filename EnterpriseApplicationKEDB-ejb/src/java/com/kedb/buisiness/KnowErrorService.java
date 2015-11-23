/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import javax.ejb.Local;

/**
 *
 * @author R
 */
@Local
public interface KnowErrorService {
    
    void createKnowError(String cause, String solution, String workaround, String category);
    String getKnowError(String category);
    String getKnowErrorKeyword(String keyword);
    String getKnowError();
    String getKnowErrorMySql(String category);
    String getKnowErrorMySql();
}
