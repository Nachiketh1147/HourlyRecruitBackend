package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardTitle;

    private String heading;

    @Column(length = 2000)
    private String subHeading;

    private String location;
    private String locImgUrl;

    private String email;
    private String emailImgUrl;

    private String phone;
    private String phImgUrl;

    private String website;
    private String webImgUrl;

	public String getLocImgUrl() {
		return locImgUrl;
	}

	public void setLocImgUrl(String locImgUrl) {
		this.locImgUrl = locImgUrl;
	}

	public String getEmailImgUrl() {
		return emailImgUrl;
	}

	public void setEmailImgUrl(String emailImgUrl) {
		this.emailImgUrl = emailImgUrl;
	}

	public String getPhImgUrl() {
		return phImgUrl;
	}

	public void setPhImgUrl(String phImgUrl) {
		this.phImgUrl = phImgUrl;
	}

	public String getWebImgUrl() {
		return webImgUrl;
	}

	public void setWebImgUrl(String webImgUrl) {
		this.webImgUrl = webImgUrl;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

    
}