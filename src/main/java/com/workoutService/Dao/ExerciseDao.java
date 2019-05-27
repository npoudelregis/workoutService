package com.workoutService.Dao;

import com.workoutService.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface ExerciseDao extends JpaRepository<Exercise, Long> {

    @Query("SELECT e FROM Exercise e JOIN e.tags et JOIN et.tag t WHERE LOWER(t.name) IN (:name) GROUP BY e.id HAVING COUNT(e) = :length")
    Collection<Exercise> findExerciseByTags(@Param("name") ArrayList name, @Param("length") Long length);
}
