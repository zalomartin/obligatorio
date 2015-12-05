package com.kedb.persistence;

import javax.ejb.Local;

@Local
public interface CategoryDaoService {

    void createCategory(String description);

    void deleteCategory(long id);

    void modifyCategory(long id, String description);

}
