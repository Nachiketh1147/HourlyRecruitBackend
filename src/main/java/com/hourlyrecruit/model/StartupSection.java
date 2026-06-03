package com.hourlyrecruit.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "startup_section")
public class StartupSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardTitle;

    private String heading;

    @Column(length = 3000)
    private String subHeading;

    @ElementCollection
    @CollectionTable(
            name = "startup_points",
            joinColumns = @JoinColumn(name = "startup_section_id")
    )
    private List<String> points;

    private String buttonText;

    private String buttonUrl;

    
	public String getCardTitle() {
	return cardTitle;
}

public void setCardTitle(String cardTitle) {
	this.cardTitle = cardTitle;
}

public void setPoints(List<String> points) {
	this.points = points;
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



	public List<String> getPoints() {
		return points;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getButtonUrl() {
		return buttonUrl;
	}

	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
	}

    
}