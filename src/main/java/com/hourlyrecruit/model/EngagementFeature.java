package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class EngagementFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String feature;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private EngagementModel model;

    public Long getId() {
        return id;
    }

    public String getFeature() {
        return feature;
    }

    public EngagementModel getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setModel(EngagementModel model) {
        this.model = model;
    }
}