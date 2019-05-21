package com.workoutService.Controllers;

import com.workoutService.Dao.WorkoutExercisesDao;
import com.workoutService.Entities.WorkoutExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private WorkoutExercisesDao workoutExercisesDao;

    @RequestMapping
    public Collection<WorkoutExercises> index() {
        return workoutExercisesDao.findAll();
    }

}
