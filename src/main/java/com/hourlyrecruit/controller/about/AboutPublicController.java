package com.hourlyrecruit.controller.about;

import com.hourlyrecruit.dto.AboutHeroResponse;
import com.hourlyrecruit.dto.AboutTechnologyResponse;
import com.hourlyrecruit.dto.IndustryResponse;
import com.hourlyrecruit.dto.StartupResponse;
import com.hourlyrecruit.dto.TestimonialResponse;
import com.hourlyrecruit.dto.WhatWeOfferResponse;
import com.hourlyrecruit.dto.WhyChooseUsResponse;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/about")
public class AboutPublicController {
	@Autowired
    private AboutService aboutService;


    @GetMapping("/hero")
    public AboutHeroResponse getHeroData() {

        AboutHeroResponse response =
                new AboutHeroResponse();

        response.setHeroSection(
                aboutService.getHeroes()
                        .stream()
                        .findFirst()
                        .orElse(null));

        response.setDashboardCard(
                aboutService.getDashboardCards()
                        .stream()
                        .findFirst()
                        .orElse(null));

        response.setTotalDevelopers(
                aboutService.getTotalDevelopers());

        return response;
    }

    @GetMapping("/companies")
    public List<TrustedCompany> getCompanies() {
        return aboutService.getCompanies();
    }

    @GetMapping("/what-we-offer")
    public WhatWeOfferResponse getWhatWeOffer() {

        WhatWeOfferSection section =
                aboutService.getAllSections()
                        .stream()
                        .findFirst()
                        .orElse(null);

        WhatWeOfferResponse response =
                new WhatWeOfferResponse();

        if (section != null) {
            response.setSectionId(section.getId());
            response.setSectionTitle(section.getSectionTitle());
            response.setHeading(section.getHeading()); 
            response.setSubHeading(section.getSubHeading());
        }

        response.setTechnologies(
                aboutService.getAllWhatWeOfferTechnologies()
        );

        return response;
    }

    @GetMapping("/industries")
    public IndustryResponse getIndustries() {

        IndustrySection section =
                aboutService.getIndustrySections()
                        .stream()
                        .findFirst()
                        .orElse(null);

        return new IndustryResponse(
                section,
                aboutService.getIndustries()
        );
    }
   
    @GetMapping("/category/{category}")
    public List<AboutTechnology> getByCategory(
            @PathVariable String category) {

        return aboutService.getTechnologiesByCategory(category);
    }
    @GetMapping("/technologies")
    public AboutTechnologyResponse getData() {

        AboutTechnologyResponse response =
                new AboutTechnologyResponse();

        response.setSection(
                aboutService.getTechnologySections()
                        .stream()
                        .findFirst()
                        .orElse(null)
        );

        response.setCategories(
                aboutService.getCategories()
        );

        response.setTechnologies(
                aboutService.getAllTechnologies()
        );

        return response;
    }
    @GetMapping("/startup")
    public StartupResponse getStartupSection() {

        StartupSection section =
                aboutService.getStartupSections()
                        .stream()
                        .findFirst()
                        .orElse(null);

        StartupHighlightCard card =
                aboutService.getStartupHighlightCards()
                        .stream()
                        .findFirst()
                        .orElse(null);

        StartupResponse response = new StartupResponse();

        response.setSection(section);
        response.setHighlightCard(card); 

        return response;
    }


        @GetMapping("/why-choose-us")
        public WhyChooseUsResponse getwhychooseus(){

            WhyChooseUsSection section =
                    aboutService.getWhyChooseUsSections()
                            .stream()
                            .findFirst()
                            .orElse(null);

            return new WhyChooseUsResponse(
                    section,
                    aboutService.getWhyChooseUsCards()
            );
        }
    @GetMapping("/testimonials")
    public TestimonialResponse getTestimonials() {

        TestimonialSection section =
                aboutService.getTestimonialSections()
                        .stream()
                        .findFirst()
                        .orElse(null);

        return new TestimonialResponse(
                section,
                aboutService.getTestimonials()
        );
    }
    @GetMapping("/get-started")
    public List<GetStartedSection> getGetStartedSections() {
        return aboutService.getGetStartedSections();
    }
}