package com.hourlyrecruit.dto;

import java.util.List;

public class EngagementModelDTO {

    private Long id;

    private String title;

    private String imgUrl;

    private String badge;

    private String description;

    private List<String> features;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getBadge() {
        return badge;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}