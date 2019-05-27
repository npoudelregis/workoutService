package com.workoutService.Dao;

import com.workoutService.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDao extends JpaRepository<Rating, Long> {
}
