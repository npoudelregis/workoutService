package com.workoutService.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String name;
    private Long length;

    public Workout() {

    }

    @OneToMany(mappedBy = "workout")
    Set<WorkoutExercises> exercises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Set<WorkoutExercises> getExercises() {
        return exercises;
    }

    public void setExercises(Set<WorkoutExercises> exercises) {
        this.exercises = exercises;
    }
}
