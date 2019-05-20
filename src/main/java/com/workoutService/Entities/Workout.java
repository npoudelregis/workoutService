package com.workoutService.Entities;

import javax.persistence.*;

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
}
