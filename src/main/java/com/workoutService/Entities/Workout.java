package com.workoutService.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.workoutService.Dao.WorkoutDao;
import org.springframework.beans.factory.annotation.Autowired;

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

    private Double avgrating;

    public Workout() {

    }

    @OneToMany(mappedBy = "workout")
    @JsonIgnore
    private List<WorkoutTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "workout")
    @JsonIgnoreProperties("workout")
    private List<Repetition> repetitions = new ArrayList<>();

    @OneToMany(mappedBy = "workout")
    @JsonIgnoreProperties("workout")
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    public List<Rating> getRatings() {
        return ratings;
    }

    public Double getAvgrating() {
        return avgrating;
    }

    public void setAvgrating(Double avgRating) {
        this.avgrating = avgrating;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

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

}
