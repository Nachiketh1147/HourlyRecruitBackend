package com.hourlyrecruit.controller.about;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.AboutService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/about")
public class AboutAdminController {
	@Autowired
    private AboutService aboutService;
	


    // =========================================
    // HERO
    // =========================================
	@GetMapping("/hero")
    public List<AboutHeroSection> getAllHeroSection() { 
        return aboutService.getHeroes();
    }

    @PostMapping("/hero")
    public AboutHeroSection create(
            @RequestBody AboutHeroSection hero) {

        return aboutService.createHero(hero);
    }

    @PutMapping("/hero/{id}")
    public AboutHeroSection updateHeroSection(
            @PathVariable Long id,
            @RequestBody AboutHeroSection hero) {

        return aboutService.updateHero(id, hero);
    }

    @DeleteMapping("/hero/{id}")
    public void deleteHeroSection(
            @PathVariable Long id) {

        aboutService.deleteHero(id);
    }
	 @GetMapping("/hero/dashboard")
	    public List<HeroDashboardCard> getAll() {
	        return aboutService.getDashboardCards();
	    }

	    @PostMapping("/hero/dashboard")
	    public HeroDashboardCard create(
	            @RequestBody HeroDashboardCard card) {

	        return aboutService.createDashboardCard(card);
	    }

	    @PutMapping("/hero/dashboard/{id}")
	    public HeroDashboardCard update(
	            @PathVariable Long id,
	            @RequestBody HeroDashboardCard card) {

	        return aboutService.updateDashboardCard(id, card);
	    }

	    @DeleteMapping("/hero/dashboard/{id}")
	    public void delete(
	            @PathVariable Long id) {

	        aboutService.deleteDashboardCard(id); 
	    }
	    
	 // COMPANY
    // =========================================

    @PostMapping("/company")
    public TrustedCompany createCompany(
            @RequestBody TrustedCompany company
    ) {
        return aboutService.createCompany(company);
    }

    @PutMapping("/company/{id}")
    public TrustedCompany updateCompany(
            @PathVariable Long id,
            @RequestBody TrustedCompany company
    ) {
        return aboutService.updateCompany(id, company);
    }

    @DeleteMapping("/company/{id}")
    public String deleteCompany(
            @PathVariable Long id
    ) {
        return aboutService.deleteCompany(id);
    }

    // =========================================
    // OFFER
    // =========================================

    // SECTION CRUD

    @GetMapping("/what-we-offer/section")
    public List<WhatWeOfferSection> getSections() {
        return aboutService.getAllSections();
    }

    @PostMapping("/what-we-offer/section")
    public WhatWeOfferSection createSection(
            @RequestBody WhatWeOfferSection section) {
        return aboutService.createSection(section);
    }

    @PutMapping("/what-we-offer/section/{id}")
    public WhatWeOfferSection updateSection(
            @PathVariable Long id,
            @RequestBody WhatWeOfferSection section) {
        return aboutService.updateSection(id, section); 
    }

    @DeleteMapping("/what-we-offer/section/{id}")
    public void deleteSection(@PathVariable Long id) {
        aboutService.deleteSection(id);
    }
    @GetMapping("/what-we-offer/technologies")
    public List<WhatWeOfferTechnologies> getofferTechnologies() {
        return aboutService.getAllWhatWeOfferTechnologies();
    }

    @PostMapping("/what-we-offer/technologies")
    public WhatWeOfferTechnologies createofferTechnology(
            @RequestBody WhatWeOfferTechnologies technology) {
        return aboutService.createWhatweofferTechnology(technology);
    }

    @PutMapping("/what-we-offer/technologies/{id}")
    public WhatWeOfferTechnologies updateofferTechnology(
            @PathVariable Long id,
            @RequestBody WhatWeOfferTechnologies technology) {
        return aboutService.updateWhatWeOfferTechnology(id, technology);
    }

    @DeleteMapping("/what-we-offer/technologies/{id}")
    public void deleteofferTechnology(@PathVariable Long id) {
        aboutService.deleteWhatWeOfferTechnology(id);
    }

    // =========================================
    // TECHNOLOGY 
    // =========================================


    @GetMapping("/technologies/section")
    public List<AboutTechnologySection> gettechnologySections() {
        return aboutService.getTechnologySections();
    }

    @PostMapping("/technologies/section")
    public AboutTechnologySection createtechnologySection( 
            @RequestBody AboutTechnologySection section) {

        return aboutService.createTechnologySection(section);
    }

    @PutMapping("/technologies/section/{id}")
    public AboutTechnologySection updatetechnologySection(
            @PathVariable Long id,
            @RequestBody AboutTechnologySection section) {

        return aboutService.updateTechnologySection(id, section);
    }

    @DeleteMapping("/technologies/section/{id}")
    public void deletetechnologySection(
            @PathVariable Long id) {

        aboutService.deleteTechnologySection(id);
    }
    @GetMapping("/technology/technologies")
    public List<AboutTechnology> getTechnologies() {
        return aboutService.getAllTechnologies();
    }

    @PostMapping("/technology/technologies")
    public AboutTechnology createTechnology(
            @RequestBody AboutTechnology technology) {

        return aboutService.createTechnology(technology);
    }

    @PutMapping("/technology/technologies/{id}")
    public AboutTechnology updateTechnology(
            @PathVariable Long id,
            @RequestBody AboutTechnology technology) {

        return aboutService.updateTechnology(id, technology);
    }

    @DeleteMapping("/technology/technologies/{id}")
    public void deleteTechnology(
            @PathVariable Long id) {

        aboutService.deleteTechnology(id);
    }

    // ========================================= 
    // INDUSTRY
    // =========================================

    @PostMapping("/industry-section")
    public IndustrySection createIndustrySection(
            @RequestBody IndustrySection section) {

        return aboutService.createIndustrySection(section);
    }

    @PutMapping("/industry-section/{id}")
    public IndustrySection updateIndustrySection(
            @PathVariable Long id,
            @RequestBody IndustrySection section) {

        return aboutService.updateIndustrySection(id, section);
    }

    @DeleteMapping("/industry-section/{id}")
    public void deleteIndustrySection(
            @PathVariable Long id) {

        aboutService.deleteIndustrySection(id);
    }
    @PostMapping("/industry")
    public Industry createIndustry(
            @RequestBody Industry industry) {

        return aboutService.createIndustry(industry);
    }

    @PutMapping("/industry/{id}")
    public Industry updateIndustry(
            @PathVariable Long id,
            @RequestBody Industry industry) {

        return aboutService.updateIndustry(id, industry);
    }

    @DeleteMapping("/industry/{id}")
    public void deleteIndustry(
            @PathVariable Long id) {

        aboutService.deleteIndustry(id);
    }

    // =========================================
    // STARTUP SECTION
    // =========================================

    @PostMapping("/startup-section")
    public StartupSection createStartupSection(
            @RequestBody StartupSection section) {

        return aboutService.createStartupSection(section);
    }

    @PutMapping("/startup-section/{id}")
    public StartupSection updateStartupSection(
            @PathVariable Long id,
            @RequestBody StartupSection section) {

        return aboutService.updateStartupSection(id, section);
    }

    @DeleteMapping("/startup-section/{id}")
    public void deleteStartupSection(
            @PathVariable Long id) {

        aboutService.deleteStartupSection(id);
    }

    // Highlight Card

    @PostMapping("/startup-highlight-card")
    public StartupHighlightCard createCard(
            @RequestBody StartupHighlightCard card) {

        return aboutService.createStartupHighlightCard(card);
    }

    @PutMapping("/startup-highlight-card/{id}")
    public StartupHighlightCard updateCard(
            @PathVariable Long id,
            @RequestBody StartupHighlightCard card) {

        return aboutService.updateStartupHighlightCard(id, card);
    }

    @DeleteMapping("/startup-highlight-card/{id}")
    public void deleteCard(
            @PathVariable Long id) {

        aboutService.deleteStartupHighlightCard(id);
    } 
    //Why Choose Us
    // SECTION

    @PostMapping("/why-choose-us/section")
    public WhyChooseUsSection createwhychooseusSection(
            @RequestBody WhyChooseUsSection section) {

        return aboutService.createWhyChooseUsSection(section);
    }

    @PutMapping("/why-choose-us/section/{id}")
    public WhyChooseUsSection updatewhychooseusSection(
            @PathVariable Long id,
            @RequestBody WhyChooseUsSection section) {

        return aboutService.updateWhyChooseUsSection(id, section);
    }

    @DeleteMapping("/why-choose-us/section/{id}")
    public void deletewhychooseusSection(@PathVariable Long id) {

        aboutService.deleteWhyChooseUsSection(id);
    }

    // CARDS

    @PostMapping("/why-choose-us/card")
    public WhyChooseUsCard createwhychooseusCard(
            @RequestBody WhyChooseUsCard card) {

        return aboutService.createWhyChooseUsCard(card);
    }

    @PutMapping("/why-choose-us/card/{id}")
    public WhyChooseUsCard updatewhychooseusCard(
            @PathVariable Long id,
            @RequestBody WhyChooseUsCard card) {

        return aboutService.updateWhyChooseUsCard(id, card);
    }

    @DeleteMapping("/why-choose-us/card/{id}")
    public void deletewhychooseusCard(@PathVariable Long id) {

        aboutService.deleteWhyChooseUsCard(id);
    }
    //Testimonial
    // SECTION

    @PostMapping("/testimonial/section")
    public TestimonialSection createtestimonialSection(
            @RequestBody TestimonialSection section) {

        return aboutService.createTestimonialSection(section);
    }

    @PutMapping("/testimonial/section/{id}")
    public TestimonialSection updatetestimonialSection(
            @PathVariable Long id,
            @RequestBody TestimonialSection section) {

        return aboutService.updateTestimonialSection(id, section);
    }

    @DeleteMapping("/testimonial/section/{id}")
    public void deletetestimonialSection(@PathVariable Long id) {

        aboutService.deleteTestimonialSection(id);
    }

    // TESTIMONIALS

    @PostMapping("/testimonial")
    public Testimonial createTestimonial(
            @RequestBody Testimonial testimonial) {

        return aboutService.createTestimonial(testimonial);
    }

    @PutMapping("/testimonial/{id}")
    public Testimonial updateTestimonial(
            @PathVariable Long id,
            @RequestBody Testimonial testimonial) {

        return aboutService.updateTestimonial(id, testimonial);
    }

    @DeleteMapping("/testimonial/{id}")
    public void deleteTestimonial(@PathVariable Long id) {

        aboutService.deleteTestimonial(id);
    }
    //Get Started With
    @PostMapping("/get-started")
    public GetStartedSection createGetStarted(
            @RequestBody GetStartedSection section
    ) {
        return aboutService.createGetStarted(section);
    }

    @PutMapping("/get-started/{id}")
    public GetStartedSection updateGetStarted(
            @PathVariable Long id,
            @RequestBody GetStartedSection section
    ) {
        return aboutService.updateGetStarted(id, section);
    }

    @DeleteMapping("/get-started/{id}")
    public String deleteGetStarted(
            @PathVariable Long id
    ) {
        return aboutService.deleteGetStarted(id);
    }
}