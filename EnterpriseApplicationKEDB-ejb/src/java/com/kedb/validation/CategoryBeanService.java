/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.validation;

import javax.ejb.Local;

@Local
public interface CategoryBeanService {

    void createCategory(String description);

    void deleteCategory(long id);

    void modifyCategory(long id, String description);

}
