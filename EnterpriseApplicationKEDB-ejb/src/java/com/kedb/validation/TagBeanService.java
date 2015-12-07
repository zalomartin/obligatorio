/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.validation;

import javax.ejb.Local;

@Local
public interface TagBeanService {

    void createTag(String description);

    void modifyTag(long id, String description);

    void deleteTag(long id);

}
