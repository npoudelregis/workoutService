package com.workoutService.Dao;

import com.workoutService.Entities.Repetition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepetitionDao extends JpaRepository<Repetition, Long> {
}
