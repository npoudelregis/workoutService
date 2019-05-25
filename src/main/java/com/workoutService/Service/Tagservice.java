package com.workoutService.Service;

import com.workoutService.Dao.TagDao;
import com.workoutService.Entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Tagservice {
    @Autowired
    private TagDao tagDao;

    public Collection<Tag> index(){
        return tagDao.findAll();
    }
}
