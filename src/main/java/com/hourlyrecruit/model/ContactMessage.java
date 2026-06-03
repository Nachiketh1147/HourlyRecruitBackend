package com.hourlyrecruit.model;

import jakarta.persistence.*;

@Entity
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private LookingFor lookingFor;

    @Enumerated(EnumType.STRING)
    private BudgetRange budgetRange;

    @Column(length = 5000)
    private String projectDescription;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LookingFor getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(LookingFor lookingFor) {
		this.lookingFor = lookingFor;
	}

	public BudgetRange getBudgetRange() {
		return budgetRange;
	}

	public void setBudgetRange(BudgetRange budgetRange) {
		this.budgetRange = budgetRange;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

    
}