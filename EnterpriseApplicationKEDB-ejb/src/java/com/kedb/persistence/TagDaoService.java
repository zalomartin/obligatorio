package com.kedb.persistence;

import javax.ejb.Local;

@Local
public interface TagDaoService {

    void createTag(String description);

    void deleteTag(long id);

    void modifyTag(long id, String description);

}
