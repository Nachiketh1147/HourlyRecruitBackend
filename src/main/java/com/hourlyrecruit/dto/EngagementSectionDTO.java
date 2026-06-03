package com.hourlyrecruit.dto;

import java.util.List;

public class EngagementSectionDTO {

    private Long id;

    private String cardTitle;

    private String heading;

    private String subHeading;

    private List<EngagementModelDTO> models;

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

    public List<EngagementModelDTO> getModels() {
        return models;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public void setModels(List<EngagementModelDTO> models) {
        this.models = models;
    }
}