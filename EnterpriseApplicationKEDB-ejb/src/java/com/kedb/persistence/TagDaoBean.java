/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.persistence;

import javax.ejb.Stateless;

@Stateless
public class TagDaoBean implements TagDaoService {

    @Override
    public void createTag(String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteTag(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modifyTag(long id, String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
