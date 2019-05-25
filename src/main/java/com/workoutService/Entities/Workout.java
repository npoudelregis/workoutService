package com.workoutService.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long length;

    public Workout() {

    }

    @OneToMany(mappedBy = "workout")
    @JsonIgnoreProperties("workouts")
    private List<WorkoutExercises> exercises = new ArrayList<>();

    @OneToMany(mappedBy = "workout")
    @JsonIgnore
    private List<WorkoutTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "workout")
    @JsonIgnoreProperties("workout")
    private List<Repetition> repetitions = new ArrayList<>();

    public List<WorkoutTag> getTags() {
        return tags;
    }

    public void setTags(List<WorkoutTag> tags) {
        this.tags = tags;
    }

    public List<Repetition> getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(List<Repetition> repetitions) {
        this.repetitions = repetitions;
    }


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
