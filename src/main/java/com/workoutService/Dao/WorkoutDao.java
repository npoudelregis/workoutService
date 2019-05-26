package com.workoutService.Dao;

import com.workoutService.Entities.Workout;
import com.workoutService.Entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface WorkoutDao extends JpaRepository<Workout, Long> {
    @Query("SELECT w FROM Workout w JOIN w.tags wt JOIN wt.tag t WHERE LOWER(t.name) = LOWER(:name)")
    Collection<Workout> findWorkoutByTags(@Param("name") String name);


    @Query("SELECT avg(r.rating) FROM Workout w LEFT OUTER JOIN w.ratings r WHERE w.id = :id GROUP BY w.id")
    Double getAvgRating(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Workout w SET w.avgrating = :newRating where w.id = :id")
    void updateRating(@Param("newRating") Double newRating, @Param("id") Long id);

}
