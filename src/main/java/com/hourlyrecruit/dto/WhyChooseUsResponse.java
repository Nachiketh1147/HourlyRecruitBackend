package com.hourlyrecruit.dto;

import java.util.List;

import com.hourlyrecruit.model.WhyChooseUsSection;
import com.hourlyrecruit.model.WhyChooseUsCard;

public class WhyChooseUsResponse {

    private WhyChooseUsSection section;

    private List<WhyChooseUsCard> cards;

    public WhyChooseUsResponse() {
    }

    public WhyChooseUsResponse(
            WhyChooseUsSection section,
            List<WhyChooseUsCard> cards) {

        this.section = section;
        this.cards = cards;
    }

    public WhyChooseUsSection getSection() {
        return section;
    }

    public void setSection(WhyChooseUsSection section) {
        this.section = section;
    }

    public List<WhyChooseUsCard> getCards() {
        return cards;
    }

    public void setCards(List<WhyChooseUsCard> cards) {
        this.cards = cards;
    }
}