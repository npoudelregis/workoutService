package com.workoutService.Controllers;

import com.workoutService.Entities.Workout;
import com.workoutService.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class WorkoutsController {

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping("/workouts")
    public Collection<Workout> index(){
        return workoutService.index();
    }
}
