package com.workoutService;

import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Workout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public  void
    test_id_of_the_first_workout() {
        assertThat(workoutDao.findById(1L).get().getId())
                .isEqualTo(1);
    }


}
