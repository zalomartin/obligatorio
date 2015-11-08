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
public class TagDaoBean implements TagDaoService {

    @Override
    public void createTag(String description) {
    }

    @Override
    public void deleteTag(long id) {
    }

    @Override
    public void modifyTag(long id, String description) {
    }
}
