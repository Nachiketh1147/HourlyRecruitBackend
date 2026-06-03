package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class ContactMessageSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Section Name for frontend click/filter
    private String sectionName;

    // Card title
    private String cardTitle;

    // Enable/Disable form
    private boolean active;

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

 

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}