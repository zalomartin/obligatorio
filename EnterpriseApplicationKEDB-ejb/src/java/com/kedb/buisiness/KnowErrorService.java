/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import javax.ejb.Local;


@Local
public interface KnowErrorService {
    public void createKnowError(String cause, String solution, String workaround, String category);
    void findKnowError();
}
