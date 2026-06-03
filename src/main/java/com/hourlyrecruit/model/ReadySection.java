package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class ReadySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardTitle;

    private String heading;
    private String subHeading;

    private String primaryButton;
    private String primaryButtonUrl;

    private String secondaryButton;
    private String secondaryButtonUrl;

    public Long getId() {
        return id;
    }

    public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	public String getPrimaryButtonUrl() {
		return primaryButtonUrl;
	}

	public void setPrimaryButtonUrl(String primaryButtonUrl) {
		this.primaryButtonUrl = primaryButtonUrl;
	}

	public String getSecondaryButtonUrl() {
		return secondaryButtonUrl;
	}

	public void setSecondaryButtonUrl(String secondaryButtonurl) {
		this.secondaryButtonUrl = secondaryButtonurl;
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