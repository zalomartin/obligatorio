/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class RoleDaoBean implements RoleDaoService {

    @Override
    public void createRole(String description) {
    }

    @Override
    public void modifyRole(long id, String description) {
    }

    @Override
    public void deleteRole(long id) {
    }
    
}
