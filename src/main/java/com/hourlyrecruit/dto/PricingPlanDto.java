package com.hourlyrecruit.dto;

import java.util.List;

public class PricingPlanDto {

    private Long id;

    private String type;

    private String title;
 
    private String badge;

    private String price;

    private String description;

    private String buttonText;

    private String buttonTextUrl;

    private List<PricingFeatureDto> features;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonTextUrl() {
        return buttonTextUrl;
    }

    public void setButtonTextUrl(String buttonTextUrl) {
        this.buttonTextUrl = buttonTextUrl;
    }

    public List<PricingFeatureDto> getFeatures() {
        return features;
    }

    public void setFeatures(List<PricingFeatureDto> features) {
        this.features = features;
    }
}