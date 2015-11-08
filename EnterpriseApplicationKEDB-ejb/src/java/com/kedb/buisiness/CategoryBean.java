/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import com.kedb.persistence.CategoryDaoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gonzalo.martin
 */
@Stateless
public class CategoryBean implements CategoryBeanService {
    
@EJB
private CategoryDaoService categoryDao;

    @Override
    public void createCategory(String description) {
        categoryDao.createCategory(description);
    }

    @Override
    public void deleteCategory(long id) {
        categoryDao.deleteCategory(id);
    }

    @Override
    public void modifyCategory(long id, String description) {
        categoryDao.modifyCategory(id, description);
    }
}
