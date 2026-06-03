package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class LetsBuildTogether {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
// Card Title
    private String cardTitle;
    // Main Heading
    private String heading;
    // Sub Heading
    @Column(length = 3000)
    private String subHeading;
    // Image
    private String image1Url;
    // Point 1
    private String pointOneTitle;
    @Column(length = 1000)
    private String pointOneDescription;
    private String image2Url;
    // Point 2
    private String pointTwoTitle;
    @Column(length = 1000)
    private String pointTwoDescription;
    private String image3Url;
    public String getImage1Url() {
		return image1Url;
	}

	public void setImage1Url(String image1Url) {
		this.image1Url = image1Url;
	}

	public String getImage2Url() {
		return image2Url;
	}

	public void setImage2Url(String image2Url) {
		this.image2Url = image2Url;
	}

	public String getImage3Url() {
		return image3Url;
	}

	public void setImage3Url(String image3Url) {
		this.image3Url = image3Url;
	}

	// Point 3
    private String pointThreeTitle;
    @Column(length = 1000)
    private String pointThreeDescription;

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

    public String getPointOneTitle() {
        return pointOneTitle;
    }

    public void setPointOneTitle(String pointOneTitle) {
        this.pointOneTitle = pointOneTitle;
    }

    public String getPointOneDescription() {
        return pointOneDescription;
    }

    public void setPointOneDescription(String pointOneDescription) {
        this.pointOneDescription = pointOneDescription;
    }

    public String getPointTwoTitle() {
        return pointTwoTitle;
    }

    public void setPointTwoTitle(String pointTwoTitle) {
        this.pointTwoTitle = pointTwoTitle;
    }

    public String getPointTwoDescription() {
        return pointTwoDescription;
    }

    public void setPointTwoDescription(String pointTwoDescription) {
        this.pointTwoDescription = pointTwoDescription;
    }

    public String getPointThreeTitle() {
        return pointThreeTitle;
    }

    public void setPointThreeTitle(String pointThreeTitle) {
        this.pointThreeTitle = pointThreeTitle;
    }

    public String getPointThreeDescription() {
        return pointThreeDescription;
    }

    public void setPointThreeDescription(String pointThreeDescription) {
        this.pointThreeDescription = pointThreeDescription;
    }
}