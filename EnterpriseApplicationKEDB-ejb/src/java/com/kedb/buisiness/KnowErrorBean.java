/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.KnowErrorDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rolol
 */
@Stateless
public class KnowErrorBean implements KnowErrorService {

@EJB
private KnowErrorDao knowErrorDao;

    @Override
    public void createKnowError(String name) {
         //TODO: validaciones,logica
         knowErrorDao.createKnowError(name);
    }

}
