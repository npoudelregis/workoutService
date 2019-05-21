package com.workoutService.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String name;
    private String description;
    private String img_url;


    public Exercise() {
    }

    @OneToMany(mappedBy = "exercise")
    Set<WorkoutExercises> workouts;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Set<WorkoutExercises> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<WorkoutExercises> workouts) {
        this.workouts = workouts;
    }
}
