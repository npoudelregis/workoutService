package com.workoutService;

import com.workoutService.Dao.ExerciseDao;
import com.workoutService.Entities.Exercise;
import com.workoutService.Entities.Workout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExerciseTest {

    @Autowired
    private ExerciseDao exerciseDao;
    private Exercise exercise;

    @Test
    public void
    test_get_by_tags() {
        ArrayList<String> arrayTag = new ArrayList<String>();
        arrayTag.add("tag1");
        arrayTag.add("tag2");
        arrayTag.add("tag3");
        Collection<Exercise> exercises = exerciseDao.findExerciseByTags(arrayTag, 3L);
        assertThat(exercises.size())
                .isEqualTo(1);
    }
}
