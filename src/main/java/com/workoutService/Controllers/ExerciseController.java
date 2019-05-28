package com.workoutService.Controllers;

import com.workoutService.Entities.Exercise;
import com.workoutService.POJO.NewExercise;
import com.workoutService.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/exercises/{id}")
    public Object getExerciseById(@PathVariable(name= "id") Long id) {
        return exerciseService.show(id);
    }

    @GetMapping("/exercisesByTag")
    public Collection<Exercise> getExerciseByTags(@RequestParam(name = "tags") ArrayList tags) {
        Long length = Long.valueOf(tags.size());
        return exerciseService.exerciseByTags(tags, length);
    }

    @PostMapping("/exercises")
    public Exercise create(@RequestBody NewExercise exercise) { return exerciseService.create(exercise); }
}

