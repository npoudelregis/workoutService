package com.workoutService.Service;

import com.workoutService.Dao.ExerciseDao;
import com.workoutService.Dao.RepetitionDao;
import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Exercise;
import com.workoutService.Entities.Repetition;
import com.workoutService.Entities.Workout;
import com.workoutService.POJO.NewRepetition;
import com.workoutService.POJO.NewWorkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private WorkoutDao workoutDao;

    @Autowired
    private RepetitionDao repetitionDao;

    public Collection<Workout> index(){
        return workoutDao.findAllTopRated();
    }

    public Workout create(NewWorkout workout) {
        Workout createdWorkout = createWorkout(workout);
        Workout savedWorkout = workoutDao.save(createdWorkout);
        createRepetitions(savedWorkout, workout.getExercises());
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

    private Workout createWorkout(NewWorkout workout) {
        Workout newWorkout = new Workout();
        newWorkout.setName(workout.getName());
        newWorkout.setLength(workout.getLength());
        return newWorkout;
    }

    public Void createRepetitions(Workout workout, List<NewRepetition> exercises) {
        for (int i = 0; i < exercises.size(); i++) {
            Repetition newRepetition = new Repetition();
            newRepetition.setWorkout(workout);
            Long exerciseId = exercises.get(i).getId();
            Optional<Exercise> exercise = exerciseDao.findById(exerciseId);
            if (exercise.isPresent()) {
                Exercise foundExercise = exercise.get();
                newRepetition.setExercise(foundExercise);
            }
            newRepetition.setDescription(exercises.get(i).getRepetitions());
            repetitionDao.save(newRepetition);
        }
        return null;
    }
}
