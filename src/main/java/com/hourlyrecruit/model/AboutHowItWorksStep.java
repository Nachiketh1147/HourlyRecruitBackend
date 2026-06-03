package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class AboutHowItWorksStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stepNumber;

    private String title;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private AboutHowItWorksSection section;

    public Long getId() {
        return id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AboutHowItWorksSection getSection() {
        return section;
    }

    public void setSection(AboutHowItWorksSection section) {
        this.section = section;
    }

    public void setId(Long id) {
        this.id = id;
    }
}