/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import javax.ejb.Local;

/**
 *
 * @author rolol
 */
@Local
public interface KnowErrorDao {
    public void createKnowError(String name);
}
