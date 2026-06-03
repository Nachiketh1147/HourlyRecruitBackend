package com.hourlyrecruit.dto;

import java.util.List;

import com.hourlyrecruit.model.AboutTechnology;
import com.hourlyrecruit.model.AboutTechnologySection;

public class AboutTechnologyResponse {

    private AboutTechnologySection section;

    private List<String> categories;

    private List<AboutTechnology> technologies;

	public AboutTechnologySection getSection() {
		return section;
	}

	public void setSection(AboutTechnologySection section) {
		this.section = section;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<AboutTechnology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<AboutTechnology> technologies) {
		this.technologies = technologies;
	}

    
}