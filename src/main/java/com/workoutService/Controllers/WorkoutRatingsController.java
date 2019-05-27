package com.workoutService.Controllers;

import com.workoutService.Entities.Rating;
import com.workoutService.Entities.Workout;
import com.workoutService.POJO.NewRating;
import com.workoutService.Service.WorkoutRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workouts")

public class WorkoutRatingsController {

    @Autowired
    WorkoutRatingService workoutRatingService;

    @PostMapping("/{id}/ratings")
    public Rating create(@RequestBody NewRating rating, @PathVariable(name = "id") Long id) {
        return workoutRatingService.create(rating, id);
    }

}
