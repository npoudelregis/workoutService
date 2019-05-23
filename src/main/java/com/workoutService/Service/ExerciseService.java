package com.workoutService.Service;

import com.workoutService.Dao.ExerciseDao;
import com.workoutService.Entities.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    public Collection<Exercise> index(){
        return exerciseDao.findAll();
    }
}
