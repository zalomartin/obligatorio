
package com.kedb.persistence;

import javax.ejb.Stateless;


@Stateless
public class CategoryDaoBean implements CategoryDaoService {

    @Override
    public void createCategory(String description) {
    }

    @Override
    public void deleteCategory(long id) {
    }

    @Override
    public void modifyCategory(long id, String description) {
    }
    
}
