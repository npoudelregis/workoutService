package com.workoutService.Service;

import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Collection;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutDao workoutDao;

    public Collection<Workout> index(){
        return workoutDao.findAll();
    }

    public Workout create(Workout workout) {
        Workout savedWorkout = workoutDao.save(workout);
        return savedWorkout;
    }
    
    public Workout show(Long id) {
        Optional<Workout> workout = workoutDao.findById(id);
        if (workout.isPresent() ) {
            return workout.get();
        }
        return null;
    }

    public Collection<Workout> workoutByTags(String tags) {
        return workoutDao.findWorkoutByTags(tags);
    }
}
