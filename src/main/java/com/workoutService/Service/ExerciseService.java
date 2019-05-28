package com.workoutService.Service;

import com.workoutService.Dao.ExerciseDao;
import com.workoutService.Dao.ExerciseTagDao;
import com.workoutService.Dao.TagDao;
import com.workoutService.Entities.Exercise;
import com.workoutService.Entities.ExerciseTag;
import com.workoutService.Entities.Tag;
import com.workoutService.POJO.NewExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private ExerciseTagDao exerciseTagDao;


    public Collection<Exercise> index() {
        return exerciseDao.findAll();
    }

    public Exercise show(Long id) {
        Optional<Exercise> exercise = exerciseDao.findById(id);
        if (exercise.isPresent()) {
            return exercise.get();
        }
        return null;
    }

    public Collection<Exercise> exerciseByTags(ArrayList tags, Long length) {
        return exerciseDao.findExerciseByTags(tags, length);
    }

    public Exercise create(NewExercise exercise) {
        Exercise createdExercise = createExercise(exercise);
        Exercise savedExercise = exerciseDao.save(createdExercise);
        createTags(savedExercise, exercise.getTags());
        return savedExercise;
    }

    private Exercise createExercise(NewExercise exercise) {
        Exercise newExercise = new Exercise();
        newExercise.setName(exercise.getName());
        newExercise.setDescription(exercise.getDescription());
        newExercise.setImg_url(exercise.getImg_url());
        return newExercise;
    }

    public Void createTags(Exercise exercise, List<String> tags) {
        for (int i = 0; i < tags.size(); i++) {
            Tag newTag = new Tag();
            newTag.setName(tags.get(i));
            Tag savedTag = tagDao.save(newTag);
            ExerciseTag newExerciseTag = new ExerciseTag();
            newExerciseTag.setExercise(exercise);
            newExerciseTag.setTag(savedTag);
            exerciseTagDao.save(newExerciseTag);
        }
        return null;
    }
}
