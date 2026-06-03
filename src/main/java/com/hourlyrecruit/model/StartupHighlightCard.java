package com.hourlyrecruit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "startup_highlight_card")
public class StartupHighlightCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardTitle;

    @Column(length = 1000)
    private String description;

    private String statOneValue;
    private String statOneLabel;

    private String statTwoValue;
    private String statTwoLabel;

    private String statThreeValue;
    private String statThreeLabel;

    private String statFourValue;
    private String statFourLabel;

    private String imageUrl;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatOneValue() {
		return statOneValue;
	}

	public void setStatOneValue(String statOneValue) {
		this.statOneValue = statOneValue;
	}

	public String getStatOneLabel() {
		return statOneLabel;
	}

	public void setStatOneLabel(String statOneLabel) {
		this.statOneLabel = statOneLabel;
	}

	public String getStatTwoValue() {
		return statTwoValue;
	}

	public void setStatTwoValue(String statTwoValue) {
		this.statTwoValue = statTwoValue;
	}

	public String getStatTwoLabel() {
		return statTwoLabel;
	}

	public void setStatTwoLabel(String statTwoLabel) {
		this.statTwoLabel = statTwoLabel;
	}

	public String getStatThreeValue() {
		return statThreeValue;
	}

	public void setStatThreeValue(String statThreeValue) {
		this.statThreeValue = statThreeValue;
	}

	public String getStatThreeLabel() {
		return statThreeLabel;
	}

	public void setStatThreeLabel(String statThreeLabel) {
		this.statThreeLabel = statThreeLabel;
	}

	public String getStatFourValue() {
		return statFourValue;
	}

	public void setStatFourValue(String statFourValue) {
		this.statFourValue = statFourValue;
	}

	public String getStatFourLabel() {
		return statFourLabel;
	}

	public void setStatFourLabel(String statFourLabel) {
		this.statFourLabel = statFourLabel;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    
}