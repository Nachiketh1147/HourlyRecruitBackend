package com.hourlyrecruit.dto;

import java.util.List;

public class AboutHowItWorksResponseDto {

    private Long id;

    private String cardTitle;

    private String heading;

    private String subHeading;

    private List<AboutHowItWorksStepDto> steps;

    public Long getId() {
        return id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public List<AboutHowItWorksStepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<AboutHowItWorksStepDto> steps) {
        this.steps = steps;
    }

    public void setId(Long id) {
        this.id = id;
    }
}