package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class TechnologyCTA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardTitle;

    private String heading;

    private String description;

    private String primaryButton;
    private String primaryButtonUrl;

    private String secondaryButton;
    private String secondaryButtonUrl;

    public String getPrimaryButtonUrl() {
		return primaryButtonUrl;
	}

	public void setPrimaryButtonUrl(String primaryButtonUrl) {
		this.primaryButtonUrl = primaryButtonUrl;
	}

	public String getSecondaryButtonUrl() {
		return secondaryButtonUrl;
	}

	public void setSecondaryButtonUrl(String secondaryButtonUrl) {
		this.secondaryButtonUrl = secondaryButtonUrl;
	}

	public TechnologyCTA() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryButton() {
        return primaryButton;
    }

    public void setPrimaryButton(String primaryButton) {
        this.primaryButton = primaryButton;
    }

    public String getSecondaryButton() {
        return secondaryButton;
    }

    public void setSecondaryButton(String secondaryButton) {
        this.secondaryButton = secondaryButton;
    }

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
}