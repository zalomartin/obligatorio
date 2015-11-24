
package com.kedb.buisiness;

import com.kedb.persistence.CategoryDaoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;


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
