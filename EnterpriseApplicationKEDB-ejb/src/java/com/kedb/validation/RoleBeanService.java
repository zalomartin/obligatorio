/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.validation;

import com.kedb.entities.RoleEntity;
import com.kedb.exceptions.ApplicationKEDBException;
import javax.ejb.Local;

@Local
public interface RoleBeanService {

    void createRole(String description);

    void deleteRole(long id);

    void modifyRole(long id, String description);

    RoleEntity getRole(String description) throws ApplicationKEDBException;

}
