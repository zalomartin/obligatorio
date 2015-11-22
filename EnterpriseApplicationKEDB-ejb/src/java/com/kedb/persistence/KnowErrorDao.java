/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.KnowError;
import javax.ejb.Local;


@Local
public interface KnowErrorDao {
    void createKnowError(KnowError knowError);
}
