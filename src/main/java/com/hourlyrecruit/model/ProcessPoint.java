package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class ProcessPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String point;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private ProcessStep step;

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public ProcessStep getStep() {
        return step;
    }

    public void setStep(ProcessStep step) {
        this.step = step;
    }

    public void setId(Long id) {
        this.id = id;
    }
}