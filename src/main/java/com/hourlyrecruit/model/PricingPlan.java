package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class PricingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PricingType type;

    private String title;

    private String badge;

    private String price;

    @Column(length = 2000)
    private String description;

    private String buttonText;

    private String buttonTextUrl;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private PricingSection section;

    public Long getId() {
        return id;
    }

    public PricingType getType() {
        return type;
    }

    public void setType(PricingType type) {
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

    public PricingSection getSection() {
        return section;
    }

    public void setSection(PricingSection section) {
        this.section = section;
    }

    public void setId(Long id) {
        this.id = id;
    }
}