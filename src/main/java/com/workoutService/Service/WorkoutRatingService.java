package com.workoutService.Service;

import com.workoutService.Dao.RatingDao;
import com.workoutService.Dao.WorkoutDao;
import com.workoutService.Entities.Rating;
import com.workoutService.Entities.Workout;
import com.workoutService.POJO.NewRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutRatingService {

    @Autowired
    private RatingDao ratingDao;

    @Autowired
    private WorkoutDao workoutDao;

    public Rating create(NewRating rating, Long workoutId) {
        Optional<Workout> optWorkout = workoutDao.findById(workoutId);
        if (optWorkout.isPresent() ) {
            Workout workout = optWorkout.get();
            Rating newRating = new Rating();
            newRating.setRating(rating.getRating());
            newRating.setWorkout(workout);
            ratingDao.save(newRating);
            Double newAvg = workoutDao.getAvgRating(workoutId);
            workoutDao.updateRating(newAvg, workoutId);
            return newRating;
        }
        return null;
    }
}
