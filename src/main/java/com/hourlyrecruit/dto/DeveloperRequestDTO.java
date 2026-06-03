package com.hourlyrecruit.dto;

import com.hourlyrecruit.model.DeveloperCategory;
import com.hourlyrecruit.model.DeveloperStatus;

public class DeveloperRequestDTO {

    private String fullName;

    private String designation;

    private String experience;

    private String skills;

    private DeveloperStatus status; 

    private Double hourlyRate;

    private String profileImage;

    private String resumeUrl;

    private String githubUrl;

    private String linkedinUrl;

    private DeveloperCategory category;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public String getGithubUrl() {
		return githubUrl;
	}

	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public DeveloperCategory getCategory() {
		return category;
	}

	public void setCategory(DeveloperCategory category) {
		this.category = category;
	}

	public DeveloperStatus getStatus() {
		return status;
	}

	public void setStatus(DeveloperStatus status) {
		this.status = status;
	}

    
}