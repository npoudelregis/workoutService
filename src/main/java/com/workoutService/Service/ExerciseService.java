package com.workoutService.Service;

import com.workoutService.Dao.ExerciseDao;
import com.workoutService.Entities.Exercise;
import com.workoutService.Entities.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    public Collection<Exercise> index(){
        return exerciseDao.findAll();
    }

    public Exercise show(Long id) {
        Optional<Exercise> exercise = exerciseDao.findById(id);
        if (exercise.isPresent() ) {
            return exercise.get();
        }
        return null;
    }

    public Collection<Exercise> exerciseByTags(String tags) {
        return exerciseDao.findExerciseByTags(tags);
    }
}
