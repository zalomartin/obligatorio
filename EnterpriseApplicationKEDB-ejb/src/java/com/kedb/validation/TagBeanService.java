
package com.kedb.validation;

import javax.ejb.Local;


@Local
public interface TagBeanService {

    void createTag(String description);
    void modifyTag(long id, String description);
    void deleteTag(long id);
    
}
