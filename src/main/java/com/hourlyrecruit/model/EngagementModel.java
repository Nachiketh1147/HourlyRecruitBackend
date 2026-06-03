package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class EngagementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imgUrl;

    private String badge;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private EngagementSection section;

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

    public EngagementSection getSection() {
        return section;
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

    public void setSection(EngagementSection section) {
        this.section = section;
    }
}