package com.hourlyrecruit.dto;

import java.util.List;

public class ProcessStepResponse {

    private Long id;

    private int stepNumber;

    private String title;

    private String description;

    private List<String> points;

    public ProcessStepResponse(
            Long id,
            int stepNumber,
            String title,
            String description,
            List<String> points
    ) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.title = title;
        this.description = description;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPoints() {
        return points;
    }
}