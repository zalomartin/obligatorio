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
