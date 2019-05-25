package com.workoutService.Controllers;

import com.workoutService.Entities.Tag;
import com.workoutService.Service.Tagservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1")
public class TagsController {
    @Autowired
    private Tagservice tagservice;

    @RequestMapping("/tags")
    public Collection<Tag> index(){
        return tagservice.index();
    }
}
