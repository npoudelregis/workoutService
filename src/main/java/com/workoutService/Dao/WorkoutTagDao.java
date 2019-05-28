package com.workoutService.Dao;

import com.workoutService.Entities.WorkoutTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutTagDao extends JpaRepository<WorkoutTag, Long> {
}
