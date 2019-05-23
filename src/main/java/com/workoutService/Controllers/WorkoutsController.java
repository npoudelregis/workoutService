package com.workoutService.Controllers;

import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Workout;
import com.workoutService.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class WorkoutsController {

    @Autowired
    private WorkoutService workoutService;
    private WorkoutDao workoutDao;

    @RequestMapping("/workouts")
    public Collection<Workout> index(){
        return workoutService.index();
    }

    @GetMapping("/workouts/{id}")
    public Object getWorkOutById(@PathVariable(name= "id") Long id) {
        return workoutService.show(id);
    }
}
