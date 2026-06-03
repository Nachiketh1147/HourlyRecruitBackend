package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer clientRating;

    @Column(length = 3000)
    private String clientFeedback;

    private String clientName;

    private String clientCompany;

    private String clientImage;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
    	this.id=id;
    }

    public Integer getClientRating() {
        return clientRating;
    }

    public void setClientRating(Integer clientRating) {
        this.clientRating = clientRating;
    }

    public String getClientFeedback() {
        return clientFeedback;
    }

    public void setClientFeedback(String clientFeedback) {
        this.clientFeedback = clientFeedback;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getClientImage() {
        return clientImage;
    }

    public void setClientImage(String clientImage) {
        this.clientImage = clientImage;
    }
}