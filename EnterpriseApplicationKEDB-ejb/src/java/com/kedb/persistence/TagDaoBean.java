
package com.kedb.persistence;

import javax.ejb.Stateless;


@Stateless
public class TagDaoBean implements TagDaoService {

    @Override
    public void createTag(String description) {
    }

    @Override
    public void deleteTag(long id) {
    }

    @Override
    public void modifyTag(long id, String description) {
    }
}
