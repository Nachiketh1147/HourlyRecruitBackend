package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class StartTodaySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardTitle;

    private String heading;

    @Column(length = 1000)
    private String subHeading; 

    private String primaryButtonText;
    private String primaryButtonTextUrl;

    private String secondaryButtonText;
    private String secondaryButtonTextUrl;

    public String getPrimaryButtonTextUrl() {
		return primaryButtonTextUrl;
	}

	public void setPrimaryButtonTextUrl(String primaryButtonTextUrl) {
		this.primaryButtonTextUrl = primaryButtonTextUrl;
	}

	public String getSecondaryButtonTextUrl() {
		return secondaryButtonTextUrl;
	}

	public void setSecondaryButtonTextUrl(String secondaryButtonTextUrl) {
		this.secondaryButtonTextUrl = secondaryButtonTextUrl;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPrimaryButtonText() {
        return primaryButtonText;
    }

    public void setPrimaryButtonText(String primaryButtonText) {
        this.primaryButtonText = primaryButtonText;
    }

    public String getSecondaryButtonText() {
        return secondaryButtonText;
    }

    public void setSecondaryButtonText(String secondaryButtonText) {
        this.secondaryButtonText = secondaryButtonText;
    }

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
}