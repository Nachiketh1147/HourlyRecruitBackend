package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class DeveloperSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skill;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    public Long getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}