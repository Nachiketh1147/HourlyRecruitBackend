package com.hourlyrecruit.dto;

import java.util.List;

import com.hourlyrecruit.model.Industry;
import com.hourlyrecruit.model.IndustrySection;

public class IndustryResponse {

    private IndustrySection section;

    private List<Industry> industries;

    public IndustryResponse() {
    }

    public IndustryResponse(
            IndustrySection section,
            List<Industry> industries) {

        this.section = section;
        this.industries = industries;
    }

    public IndustrySection getSection() {
        return section;
    }

    public void setSection(IndustrySection section) {
        this.section = section;
    }

    public List<Industry> getIndustries() {
        return industries;
    }

    public void setIndustries(List<Industry> industries) {
        this.industries = industries;
    }
}