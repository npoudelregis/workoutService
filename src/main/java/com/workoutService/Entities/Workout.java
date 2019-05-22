package com.workoutService.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    @JsonIgnoreProperties("workouts")
    private List<WorkoutExercises> exercises = new ArrayList<>();

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

    public List<WorkoutExercises> getExercises() {
        return exercises;
    }

    public void setExercises(List<WorkoutExercises> exercises) {
        this.exercises = exercises;
    }
}
