package com.workoutService.PlainObjects;
import java.util.ArrayList;
import java.util.List;

public class NewWorkout {
    public NewWorkout() {
    }

    private String name;

    private Long length;

    private List<NewRepetition> exercises = new ArrayList<>();

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

    public List<NewRepetition> getExercises() {
        return exercises;
    }

    public void setExercises(List<NewRepetition> exercises) {
        this.exercises = exercises;
    }
}
