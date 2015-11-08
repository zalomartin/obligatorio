/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import javax.ejb.Local;

/**
 *
 * @author gonzalo.martin
 */
@Local
public interface RoleDaoService {

    void createRole(String description);
    void modifyRole(long id, String description);
    void deleteRole(long id);
    
}
