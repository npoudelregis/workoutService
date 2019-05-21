package com.workoutService.Dao;

import com.workoutService.Entities.WorkoutExercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExercisesDao extends JpaRepository<WorkoutExercises, Long> {
}
