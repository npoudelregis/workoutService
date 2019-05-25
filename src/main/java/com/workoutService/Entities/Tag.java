package com.workoutService.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Tag() {

    }

    @OneToMany(mappedBy = "tag")
    private List<WorkoutTag> workouts = new ArrayList<>();

    @OneToMany(mappedBy = "tag")
    @JsonIgnore
    private List<ExerciseTag> exercises = new ArrayList<>();

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

    public List<WorkoutTag> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutTag> workouts) {
        this.workouts = workouts;
    }

    public List<ExerciseTag> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseTag> exercises) {
        this.exercises = exercises;
    }
}
