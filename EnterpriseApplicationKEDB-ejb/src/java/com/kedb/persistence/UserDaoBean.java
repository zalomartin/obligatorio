/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import com.kedb.entities.Role;
import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class UserDaoBean implements UserDaoBeanService {

    @Override
    public void createUser(String userName, Role role) {
    }

    @Override
    public void deleteUser(long id) {
    }

    @Override
    public void modifyUser(long id, String userName, Role role) {
    }
}
