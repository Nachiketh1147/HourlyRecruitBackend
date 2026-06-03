package com.hourlyrecruit.dto;

import java.util.List;

public class ProcessSectionResponse {

    private Long id;

    private String cardTitle;

    private String heading;

    private String subHeading;

    private List<ProcessStepResponse> steps;

    public ProcessSectionResponse(
            Long id,
            String cardTitle,
            String heading,
            String subHeading,
            List<ProcessStepResponse> steps
    ) {
        this.id = id;
        this.cardTitle = cardTitle;
        this.heading = heading;
        this.subHeading = subHeading;
        this.steps = steps;
    }

    public Long getId() {
        return id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public String getHeading() {
        return heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public List<ProcessStepResponse> getSteps() {
        return steps;
    }
}