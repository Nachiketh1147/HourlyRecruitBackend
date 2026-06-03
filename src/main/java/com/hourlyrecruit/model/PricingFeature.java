package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class PricingFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feature;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PricingPlan plan;

    public Long getId() {
        return id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public PricingPlan getPlan() {
        return plan;
    }

    public void setPlan(PricingPlan plan) {
        this.plan = plan;
    }

    public void setId(Long id) {
        this.id = id;
    }
}