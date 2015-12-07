/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.RoleEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;

@Local
public interface RoleDaoService {

    void createRole(String description);

    void modifyRole(long id, String description);

    void deleteRole(long id);

    RoleEntity getRole(String description) throws ApplicationKEDBException;

}
