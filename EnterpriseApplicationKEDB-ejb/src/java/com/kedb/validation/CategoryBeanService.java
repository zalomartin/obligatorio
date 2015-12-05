package com.kedb.validation;

import javax.ejb.Local;

@Local
public interface CategoryBeanService {

    void createCategory(String description);

    void deleteCategory(long id);

    void modifyCategory(long id, String description);

}
