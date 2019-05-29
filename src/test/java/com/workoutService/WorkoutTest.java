package com.workoutService;

import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Workout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WorkoutTest {
    @Autowired
    private WorkoutDao workoutDao;
    private Workout workout;

    @Test
    public void
    test_name_of_the_first_workout() {
        assertThat(workoutDao.findById(1L).get().getName())
                .isEqualTo("Workout 1");
    }

    @Test
    public  void
    test_id_of_the_first_workout() {
        assertThat(workoutDao.findById(1L).get().getId())
                .isEqualTo(1);
    }

    @Test
    public void
    test_get_avg_rating() {
        assertThat(workoutDao.getAvgRating(1L))
                .isEqualTo(4.0D);
    }

    @Test
    public void
    test_find_all_top_rated() {
        Collection<Workout> workouts = workoutDao.findAllTopRated();
        assertThat(workouts.size())
                .isEqualTo(5);
    }

    @Test
    public void
    test_get_by_tags() {
        ArrayList<String> arrayTag = new ArrayList<String>();
        arrayTag.add("cardio");
        arrayTag.add("cardio1");
        Collection<Workout> workouts = workoutDao.findWorkoutByTags(arrayTag, 2L);
        assertThat(workouts.size())
                .isEqualTo(1);
    }

}
