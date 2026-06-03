package com.hourlyrecruit.dto;

public class HireDeveloperSectionDTO {

    private Long id;

    private String cardTitle;

    private String heading;

    private Long availableDevelopers;

    private String availabilityText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAvailableDevelopers() {
        return availableDevelopers;
    }

    public void setAvailableDevelopers(Long availableDevelopers) {
        this.availableDevelopers = availableDevelopers;
    }

    public String getAvailabilityText() {
        return availabilityText;
    }

    public void setAvailabilityText(String availabilityText) {
        this.availabilityText = availabilityText;
    }
}