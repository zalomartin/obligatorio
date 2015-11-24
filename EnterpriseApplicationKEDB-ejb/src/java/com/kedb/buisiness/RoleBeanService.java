
package com.kedb.buisiness;

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
