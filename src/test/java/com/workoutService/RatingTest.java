package com.workoutService;


import com.workoutService.Dao.RatingDao;
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
public class RatingTest {
    @Autowired
    private RatingDao ratingDao;

    @Test
    public void
    test_rating_of_the_first_rating() {
        assertThat(ratingDao.findById(1L).get().getRating())
                .isEqualTo(3.0f);
    }
}
