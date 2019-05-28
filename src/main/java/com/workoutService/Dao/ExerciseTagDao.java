package com.workoutService.Dao;

import com.workoutService.Entities.ExerciseTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseTagDao extends JpaRepository<ExerciseTag, Long> {
}
