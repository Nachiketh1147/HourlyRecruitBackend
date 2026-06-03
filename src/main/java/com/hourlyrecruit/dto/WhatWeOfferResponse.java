package com.hourlyrecruit.dto;

import java.util.List;


import com.hourlyrecruit.model.WhatWeOfferTechnologies;

public class WhatWeOfferResponse {

	private Long sectionId;

    private String sectionTitle;
    private String heading;
    private String subHeading;
    public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
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

	private List<WhatWeOfferTechnologies> technologies;

    public WhatWeOfferResponse() {
    }

    public List<WhatWeOfferTechnologies> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<WhatWeOfferTechnologies> technologies) {
        this.technologies = technologies;
    }

}
