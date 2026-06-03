package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String designation;
    private String experience;
    private String Skills; 
    private Double rating;
    private Integer totalProjects;
    private Double hourlyRate;
    @Enumerated(EnumType.STRING)
    private DeveloperStatus status; 
    private String profileImage;
    private String resumeUrl;

    private String githubUrl;

    private String linkedinUrl;

    @Enumerated(EnumType.STRING)
    private DeveloperCategory category;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(Integer totalProjects) {
		this.totalProjects = totalProjects;
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}



	public DeveloperStatus getStatus() {
		return status;
	}

	public void setStatus(DeveloperStatus status) {
		this.status = status;
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


	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}


    
}