package com.workoutService.Dao;

import com.workoutService.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WorkoutDao extends JpaRepository<Workout, Long> {

}
