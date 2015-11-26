
package com.kedb.validation;

import com.kedb.persistence.TagDaoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class TagBean implements TagBeanService {
    
@EJB
private TagDaoService tagDao;

    @Override
    public void createTag(String description) {
        tagDao.createTag(description);
    }

    @Override
    public void modifyTag(long id, String description) {
        tagDao.modifyTag(id, description);
    }

    @Override
    public void deleteTag(long id) {
        tagDao.deleteTag(id);
    }
}
