package com.workoutService.Service;

import com.workoutService.Dao.*;
import com.workoutService.Entities.*;
import com.workoutService.POJO.NewRepetition;
import com.workoutService.POJO.NewWorkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TagDao tagDao;

    @Autowired
    private WorkoutTagDao workoutTagDao;

    public Collection<Workout> index(){
        return workoutDao.findAllTopRated();
    }

    public Workout create(NewWorkout workout) {
        Workout createdWorkout = createWorkout(workout);
        Workout savedWorkout = workoutDao.save(createdWorkout);
        workoutDao.updateRating(0.0, savedWorkout.getId());
        createRepetitions(savedWorkout, workout.getExercises());
        createTags(savedWorkout, workout.getTags());
        return savedWorkout;
    }

    public Workout show(Long id) {
        Optional<Workout> workout = workoutDao.findById(id);
        if (workout.isPresent() ) {
            return workout.get();
        }
        return null;
    }

    public Collection<Workout> workoutByTags(ArrayList tags, Long length) {
        return workoutDao.findWorkoutByTags(tags, length);
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

    public Void createTags(Workout workout, List<String> tags) {
        for (int i = 0; i < tags.size(); i++) {
            Tag newTag = new Tag();
            newTag.setName(tags.get(i));
            Tag savedTag = tagDao.save(newTag);
            WorkoutTag newWorkoutTag = new WorkoutTag();
            newWorkoutTag.setWorkout(workout);
            newWorkoutTag.setTag(savedTag);
            workoutTagDao.save(newWorkoutTag);
        }
        return null;
    }
}
