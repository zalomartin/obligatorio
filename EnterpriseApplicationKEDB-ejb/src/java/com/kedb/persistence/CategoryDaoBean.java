
package com.kedb.persistence;

import javax.ejb.Stateless;


@Stateless
public class CategoryDaoBean implements CategoryDaoService {

    @Override
    public void createCategory(String description) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deleteCategory(long id) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void modifyCategory(long id, String description) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }    
}
