/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.TagDaoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class TagBean implements TagBeanService {
    
@EJB
private TagDaoService tagDao;

    @Override
    public void createTag(String description) {
        tagDao.createTag(description);
    }

    @Override
    public void modifyTag(long id, String description) {
        tagDao.modifyTag(id, description);
    }

    @Override
    public void deleteTag(long id) {
        tagDao.deleteTag(id);
    }
    
    
    
    
}
