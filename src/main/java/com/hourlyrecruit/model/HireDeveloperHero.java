package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class HireDeveloperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeTitle;

    private String heading;

    @Column(length = 3000)
    private String subHeading;

    private String primaryButtonText;

    private String primaryButtonUrl;

    private String secondaryButtonText;

    private String secondaryButtonUrl;

    public Long getId() {
        return id;
    }

    public String getBadgeTitle() {
        return badgeTitle;
    }

    public void setBadgeTitle(String badgeTitle) {
        this.badgeTitle = badgeTitle;
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

    public String getPrimaryButtonText() {
        return primaryButtonText;
    }

    public void setPrimaryButtonText(String primaryButtonText) {
        this.primaryButtonText = primaryButtonText;
    }

    public String getPrimaryButtonUrl() {
        return primaryButtonUrl;
    }

    public void setPrimaryButtonUrl(String primaryButtonUrl) {
        this.primaryButtonUrl = primaryButtonUrl;
    }

    public String getSecondaryButtonText() {
        return secondaryButtonText;
    }

    public void setSecondaryButtonText(String secondaryButtonText) {
        this.secondaryButtonText = secondaryButtonText;
    }

    public String getSecondaryButtonUrl() {
        return secondaryButtonUrl;
    }

    public void setSecondaryButtonUrl(String secondaryButtonUrl) {
        this.secondaryButtonUrl = secondaryButtonUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }
}