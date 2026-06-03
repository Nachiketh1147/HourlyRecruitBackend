package com.hourlyrecruit.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.hourlyrecruit.model.StartupHighlightCard;
import com.hourlyrecruit.model.StartupSection;

public class StartupResponse {
	@Autowired
    private StartupSection section;
	@Autowired
    private StartupHighlightCard highlightCard;


    public StartupSection getSection() {
        return section;
    }

    public void setSection(StartupSection section) {
        this.section = section;
    }

    public StartupHighlightCard getHighlightCard() {
        return highlightCard;
    }

    public void setHighlightCard(
            StartupHighlightCard highlightCard) {
        this.highlightCard = highlightCard;
    }
}