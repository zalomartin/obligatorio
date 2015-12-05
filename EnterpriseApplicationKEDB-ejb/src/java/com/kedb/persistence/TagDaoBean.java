package com.kedb.persistence;

import javax.ejb.Stateless;

@Stateless
public class TagDaoBean implements TagDaoService {

    @Override
    public void createTag(String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteTag(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modifyTag(long id, String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
