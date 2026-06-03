package com.hourlyrecruit.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class AboutHeroSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardTitle;

    private String heading;

    @Column(length = 3000)
    private String subHeading;

    @ElementCollection
    private List<String> points;

    private String primaryButtonText;
    private String primaryButtonUrl;

    private String secondaryButtonText;
    private String secondaryButtonUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCardTitle() {
		return cardTitle;
	}
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
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
	public List<String> getPoints() {
		return points;
	}
	public void setPoints(List<String> points) {
		this.points = points;
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
    
}