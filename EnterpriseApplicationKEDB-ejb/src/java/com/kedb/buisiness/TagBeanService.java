/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kedb.buisiness;

import javax.ejb.Local;

/**
 *
 * @author gonzalo.martin
 */
@Local
public interface TagBeanService {

    void createTag(String description);
    void modifyTag(long id, String description);
    void deleteTag(long id);
    
}
