package com.workoutService.Controllers;

import com.workoutService.Entities.Exercise;
import com.workoutService.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping("/exercises")
    public Collection<Exercise> index(){
        return exerciseService.index();
    }
}

