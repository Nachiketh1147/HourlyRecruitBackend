package com.hourlyrecruit.dto;

import java.util.List;

import com.hourlyrecruit.model.Footer;
import com.hourlyrecruit.model.FooterQuickLink;
import com.hourlyrecruit.model.FooterServiceItem;

public class FooterResponseDTO {

    private Footer footer;

    private List<FooterQuickLink> quickLinks;

    private List<FooterServiceItem> services;

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	public List<FooterQuickLink> getQuickLinks() {
		return quickLinks;
	}

	public void setQuickLinks(List<FooterQuickLink> quickLinks) {
		this.quickLinks = quickLinks;
	}

	public List<FooterServiceItem> getServices() {
		return services;
	}

	public void setServices(List<FooterServiceItem> services) { 
		this.services = services;
	}

    
}