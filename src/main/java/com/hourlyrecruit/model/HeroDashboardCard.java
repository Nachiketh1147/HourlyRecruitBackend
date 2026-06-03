package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class HeroDashboardCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topCardText;

    private String logoUrl;

    private String dashboardHeading;

    private String dashboardSubHeading;

    private String statOneValue;
    private String statOneLabel;

    private String statTwoValue;
    private String statTwoLabel;

    private String statThreeValue;
    private String statThreeLabel;

    private Integer projectProgress;

    private Integer clientSatisfaction;

    private String bottomCardText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopCardText() {
		return topCardText;
	}

	public void setTopCardText(String topCardText) {
		this.topCardText = topCardText;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getDashboardHeading() {
		return dashboardHeading;
	}

	public void setDashboardHeading(String dashboardHeading) {
		this.dashboardHeading = dashboardHeading;
	}

	public String getDashboardSubHeading() {
		return dashboardSubHeading;
	}

	public void setDashboardSubHeading(String dashboardSubHeading) {
		this.dashboardSubHeading = dashboardSubHeading;
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

	public Integer getProjectProgress() {
		return projectProgress;
	}

	public void setProjectProgress(Integer projectProgress) {
		this.projectProgress = projectProgress;
	}

	public Integer getClientSatisfaction() {
		return clientSatisfaction;
	}

	public void setClientSatisfaction(Integer clientSatisfaction) {
		this.clientSatisfaction = clientSatisfaction;
	}

	public String getBottomCardText() {
		return bottomCardText;
	}

	public void setBottomCardText(String bottomCardText) {
		this.bottomCardText = bottomCardText;
	}

    
}