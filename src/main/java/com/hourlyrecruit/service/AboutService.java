package com.hourlyrecruit.service;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class AboutService {

	@Autowired
    private TrustedCompanyRepository trustedCompanyRepository;
	@Autowired
	private WhatWeOfferSectionRepository sectionRepository;
	@Autowired
    private WhatWeOfferTechnologiesRepository whatWeOfferRepository;
	@Autowired
	private AboutTechnologySectionRepository technologySectionRepository;
	@Autowired
    private AboutTechnologyRepository technologyRepository;
	@Autowired
	private IndustrySectionRepository industrySectionRepository;
	@Autowired
    private IndustryRepository industryRepository;
	@Autowired
    private StartupSectionRepository startupSectionRepository;
	@Autowired
	private StartupHighlightCardRepository startupHighlightCardRepository;	
	@Autowired
	private WhyChooseUsSectionRepository whyChooseUsSectionRepository;
	@Autowired
	private WhyChooseUsCardRepository whyChooseUsCardRepository;
	@Autowired
	private TestimonialSectionRepository testimonialSectionRepository;
	@Autowired
	private SiteSettingsRepository siteSettingsRepository;
	@Autowired
	private TestimonialRepository testimonialRepository;
	@Autowired
	private GetStartedSectionRepository getStartedSectionRepository;
	@Autowired
	private HeroDashboardCardRepository heroDashboardCardRepository;
	@Autowired
	private AboutHeroRepository aboutHeroRepository;

	@Autowired
	private DeveloperRepository developerRepository;

    // ========================================= 
    // HERO SECTION
    // =========================================
	// =========================================
	// ABOUT HERO SECTION
	// =========================================

	public List<AboutHeroSection> getHeroes() {
	    return aboutHeroRepository.findAll();
	}

	public AboutHeroSection createHero(
	        AboutHeroSection hero) {

	    hero.setId(null);

	    return aboutHeroRepository.save(hero);
	}

	public AboutHeroSection updateHero(
	        Long id,
	        AboutHeroSection updated) {

	    AboutHeroSection hero =
	            aboutHeroRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Hero section not found"));

	    hero.setCardTitle(updated.getCardTitle());
	    hero.setHeading(updated.getHeading());
	    hero.setSubHeading(updated.getSubHeading());

	    hero.setPoints(updated.getPoints());

	    hero.setPrimaryButtonText(
	            updated.getPrimaryButtonText());

	    hero.setPrimaryButtonUrl(
	            updated.getPrimaryButtonUrl());

	    hero.setSecondaryButtonText(
	            updated.getSecondaryButtonText());

	    hero.setSecondaryButtonUrl(
	            updated.getSecondaryButtonUrl());

	    return aboutHeroRepository.save(hero);
	}

	public void deleteHero(Long id) {
	    aboutHeroRepository.deleteById(id);
	}

	// =========================================
	// HERO DASHBOARD CARD
	// =========================================

	public List<HeroDashboardCard> getDashboardCards() {
	    return heroDashboardCardRepository.findAll();
	}

	public HeroDashboardCard createDashboardCard(
	        HeroDashboardCard card) {

	    card.setId(null);

	    return heroDashboardCardRepository.save(card);
	}

	public HeroDashboardCard updateDashboardCard(
	        Long id,
	        HeroDashboardCard updated) {

	    HeroDashboardCard existing =
	            heroDashboardCardRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Dashboard card not found"));

	    existing.setTopCardText(updated.getTopCardText());
	    existing.setLogoUrl(updated.getLogoUrl());

	    existing.setDashboardHeading(updated.getDashboardHeading());
	    existing.setDashboardSubHeading(updated.getDashboardSubHeading());

	    existing.setStatOneValue(updated.getStatOneValue());
	    existing.setStatOneLabel(updated.getStatOneLabel());

	    existing.setStatTwoValue(updated.getStatTwoValue());
	    existing.setStatTwoLabel(updated.getStatTwoLabel());

	    existing.setStatThreeValue(updated.getStatThreeValue());
	    existing.setStatThreeLabel(updated.getStatThreeLabel());

	    existing.setProjectProgress(updated.getProjectProgress());
	    existing.setClientSatisfaction(updated.getClientSatisfaction());

	    existing.setBottomCardText(updated.getBottomCardText());

	    return heroDashboardCardRepository.save(existing);
	}

	public void deleteDashboardCard(Long id) {
	    heroDashboardCardRepository.deleteById(id);
	}

	public long getTotalDevelopers() {
	    return developerRepository.count();
	}

    // =========================================
    // TRUSTED COMPANIES
    // =========================================

    public TrustedCompany createCompany(TrustedCompany company) {
        return trustedCompanyRepository.save(company);
    }

    public List<TrustedCompany> getCompanies() {
        return trustedCompanyRepository.findAll();
    }

    public TrustedCompany updateCompany(Long id,TrustedCompany updatedCompany) { 

        TrustedCompany company = trustedCompanyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));

        company.setCompanyName(updatedCompany.getCompanyName());

        return trustedCompanyRepository.save(company);
    }

    public String deleteCompany(Long id) {
        trustedCompanyRepository.deleteById(id);
        return "Company deleted successfully";
    }

    // =========================================
    // WHAT WE OFFER
    // =========================================

 // SECTION

    public List<WhatWeOfferSection> getAllSections() {
        return sectionRepository.findAll();
    }

    public WhatWeOfferSection createSection(
            WhatWeOfferSection section
    ) {
        section.setId(null);
        return sectionRepository.save(section);
    }

    public WhatWeOfferSection updateSection(
            Long id,
            WhatWeOfferSection updated
    ) {

        WhatWeOfferSection existing =
                sectionRepository.findById(id)
                        .orElseThrow();

        existing.setSectionTitle(updated.getSectionTitle());
        existing.setHeading(updated.getHeading());
        existing.setSubHeading(updated.getSubHeading());

        return sectionRepository.save(existing);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // TECHNOLOGIES

    public List<WhatWeOfferTechnologies> getAllWhatWeOfferTechnologies() {
        return whatWeOfferRepository.findAllByOrderByDisplayOrderAsc();
    }

    public WhatWeOfferTechnologies createWhatweofferTechnology( 
    		WhatWeOfferTechnologies technology
    ) {
        technology.setId(null);
        return whatWeOfferRepository.save(technology); 
    }

    public WhatWeOfferTechnologies  updateWhatWeOfferTechnology(
            Long id,
            WhatWeOfferTechnologies updated 
    ) {

    	WhatWeOfferTechnologies existing =
        		whatWeOfferRepository.findById(id)
                        .orElseThrow();

        existing.setTechnologyName(  
                updated.getTechnologyName()
        ); 

        existing.setImageUrl(
                updated.getImageUrl()
        );

        existing.setDisplayOrder(
                updated.getDisplayOrder()
        );

        return whatWeOfferRepository.save(existing);
    }

    public void deleteWhatWeOfferTechnology(Long id) { 
    	whatWeOfferRepository.deleteById(id);
    }

 

 // =========================================
 // TECHNOLOGY SECTION
 // =========================================

 public List<AboutTechnologySection> getTechnologySections() {
     return technologySectionRepository.findAll();
 }

 public AboutTechnologySection createTechnologySection(
         AboutTechnologySection section) {

     section.setId(null);

     return technologySectionRepository.save(section);
 }

 public AboutTechnologySection updateTechnologySection(
         Long id,
         AboutTechnologySection updated) {

     AboutTechnologySection existing =
             technologySectionRepository.findById(id)
                     .orElseThrow(() ->
                             new RuntimeException("Section not found"));

     existing.setCardTitle(updated.getCardTitle());
     existing.setHeading(updated.getHeading());

     return technologySectionRepository.save(existing);
 }

 public void deleteTechnologySection(Long id) {
     technologySectionRepository.deleteById(id);
 }

 // =========================================
 // TECHNOLOGIES
 // =========================================

 public AboutTechnology createTechnology(
         AboutTechnology technology) {

     technology.setId(null);

     return technologyRepository.save(technology);
 }

 public List<AboutTechnology> getAllTechnologies() {
     return technologyRepository.findAll();
 }

 public List<AboutTechnology> getTechnologiesByCategory(
         String category) {

     return technologyRepository.findByCategory(category);
 }

 public List<String> getCategories() {

     return technologyRepository.findAll()
             .stream()
             .map(AboutTechnology::getCategory)
             .filter(category -> category != null && !category.isBlank())
             .distinct()
             .toList();
 }

 public AboutTechnology updateTechnology(
         Long id,
         AboutTechnology updated) {

     AboutTechnology technology =
             technologyRepository.findById(id)
                     .orElseThrow(() ->
                             new RuntimeException("Technology not found"));

     technology.setTechnologyName(
             updated.getTechnologyName());

     technology.setCategory(
             updated.getCategory());

     return technologyRepository.save(technology);
 }

 public void deleteTechnology(Long id) {
     technologyRepository.deleteById(id);
 }

    // =========================================
    // INDUSTRIES
    // =========================================

 public List<IndustrySection> getIndustrySections() {
	    return industrySectionRepository.findAll();
	}

	public IndustrySection createIndustrySection(
	        IndustrySection section) {

	    section.setId(null);

	    return industrySectionRepository.save(section);
	}

	public IndustrySection updateIndustrySection(
	        Long id,
	        IndustrySection updated) {

	    IndustrySection existing =
	            industrySectionRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Section not found"));

	    existing.setCardTitle(updated.getCardTitle());
	    existing.setHeading(updated.getHeading());
	    existing.setSubHeading(updated.getSubHeading());

	    return industrySectionRepository.save(existing);
	}

	public void deleteIndustrySection(Long id) {
	    industrySectionRepository.deleteById(id);
	}
	public Industry createIndustry(
	        Industry industry) {

	    industry.setId(null);

	    return industryRepository.save(industry);
	}

	public List<Industry> getIndustries() {
	    return industryRepository.findAll();
	}

	public Industry updateIndustry(
	        Long id,
	        Industry updated) {

	    Industry industry =
	            industryRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Industry not found"));

	    industry.setIndustryName(
	            updated.getIndustryName());

	    industry.setDescription(
	            updated.getDescription());

	    industry.setImageUrl(
	            updated.getImageUrl());

	    return industryRepository.save(industry);
	}

	public void deleteIndustry(Long id) {
	    industryRepository.deleteById(id);
	}

    // =========================================
    // STARTUP SECTION
    // =========================================

	public List<StartupSection> getStartupSections() {
	    return startupSectionRepository.findAll();
	}

	public StartupSection createStartupSection(
	        StartupSection section) {

	    section.setId(null);

	    return startupSectionRepository.save(section);
	}

	public StartupSection updateStartupSection(
	        Long id,
	        StartupSection updated) {

	    StartupSection existing =
	            startupSectionRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Section not found"));

	    existing.setCardTitle(updated.getCardTitle());
	    existing.setHeading(updated.getHeading());
	    existing.setSubHeading(updated.getSubHeading());
	    existing.setPoints(updated.getPoints());
	    existing.setButtonText(updated.getButtonText());
	    existing.setButtonUrl(updated.getButtonUrl());

	    return startupSectionRepository.save(existing);
	}

	public void deleteStartupSection(Long id) {
	    startupSectionRepository.deleteById(id);
	}
	public List<StartupHighlightCard> getStartupHighlightCards() {
	    return startupHighlightCardRepository.findAll();
	}

	public StartupHighlightCard createStartupHighlightCard(
	        StartupHighlightCard card) {

	    card.setId(null);

	    return startupHighlightCardRepository.save(card);
	}

	public StartupHighlightCard updateStartupHighlightCard(
	        Long id,
	        StartupHighlightCard updated) {

	    StartupHighlightCard existing =
	            startupHighlightCardRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Card not found"));

	    existing.setCardTitle(updated.getCardTitle());
	    existing.setDescription(updated.getDescription());

	    existing.setStatOneValue(updated.getStatOneValue());
	    existing.setStatOneLabel(updated.getStatOneLabel());

	    existing.setStatTwoValue(updated.getStatTwoValue());
	    existing.setStatTwoLabel(updated.getStatTwoLabel());

	    existing.setStatThreeValue(updated.getStatThreeValue());
	    existing.setStatThreeLabel(updated.getStatThreeLabel());

	    existing.setStatFourValue(updated.getStatFourValue());
	    existing.setStatFourLabel(updated.getStatFourLabel());

	    existing.setImageUrl(updated.getImageUrl());

	    return startupHighlightCardRepository.save(existing);
	}

	public void deleteStartupHighlightCard(Long id) {
	    startupHighlightCardRepository.deleteById(id);
	}
    // WHY CHOOSE US
	public List<WhyChooseUsSection> getWhyChooseUsSections() {
	    return whyChooseUsSectionRepository.findAll();
	}

	public WhyChooseUsSection createWhyChooseUsSection(
	        WhyChooseUsSection section) {

	    section.setId(null);

	    return whyChooseUsSectionRepository.save(section);
	}

	public WhyChooseUsSection updateWhyChooseUsSection(
	        Long id,
	        WhyChooseUsSection updated) {

	    WhyChooseUsSection existing =
	            whyChooseUsSectionRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Section not found"));

	    existing.setCardTitle(updated.getCardTitle());
	    existing.setHeading(updated.getHeading());

	    return whyChooseUsSectionRepository.save(existing);
	}

	public void deleteWhyChooseUsSection(Long id) {
	    whyChooseUsSectionRepository.deleteById(id);
	}
	public List<WhyChooseUsCard> getWhyChooseUsCards() {
	    return whyChooseUsCardRepository.findAll();
	}

	public WhyChooseUsCard createWhyChooseUsCard(
	        WhyChooseUsCard card) {

	    card.setId(null);

	    return whyChooseUsCardRepository.save(card);
	}

	public WhyChooseUsCard updateWhyChooseUsCard(
	        Long id,
	        WhyChooseUsCard updated) {

	    WhyChooseUsCard existing =
	            whyChooseUsCardRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Card not found"));

	    existing.setHeading(updated.getHeading()); 
	    existing.setSubHeading(updated.getSubHeading()); 
	    existing.setImageUrl(updated.getImageUrl());

	    return whyChooseUsCardRepository.save(existing);
	}

	public void deleteWhyChooseUsCard(Long id) {
	    whyChooseUsCardRepository.deleteById(id);
	}
    //Testimonial
	public List<TestimonialSection> getTestimonialSections() {
	    return testimonialSectionRepository.findAll();
	}

	public TestimonialSection createTestimonialSection(
	        TestimonialSection section) {

	    section.setId(null);

	    return testimonialSectionRepository.save(section);
	}

	public TestimonialSection updateTestimonialSection(
	        Long id,
	        TestimonialSection updated) {

	    TestimonialSection existing =
	            testimonialSectionRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Section not found"));

	    existing.setCardTitle(updated.getCardTitle());
	    existing.setHeading(updated.getHeading());
	    existing.setSubHeading(updated.getSubHeading());

	    return testimonialSectionRepository.save(existing);
	}

	public void deleteTestimonialSection(Long id) {
	    testimonialSectionRepository.deleteById(id);
	}
	public List<Testimonial> getTestimonials() {
	    return testimonialRepository.findAll();
	}

	public Testimonial createTestimonial(
	        Testimonial testimonial) {

	    testimonial.setId(null);

	    return testimonialRepository.save(testimonial);
	}

	public Testimonial updateTestimonial(
	        Long id,
	        Testimonial updated) {

	    Testimonial existing =
	            testimonialRepository.findById(id)
	                    .orElseThrow(() ->
	                            new RuntimeException("Testimonial not found"));

	    existing.setClientRating(updated.getClientRating());
	    existing.setClientFeedback(updated.getClientFeedback());
	    existing.setClientName(updated.getClientName());
	    existing.setClientCompany(updated.getClientCompany());
	    existing.setClientImage(updated.getClientImage());

	    return testimonialRepository.save(existing);
	}

	public void deleteTestimonial(Long id) {
	    testimonialRepository.deleteById(id);
	}
    //Get Started Section
    public GetStartedSection createGetStarted(
            GetStartedSection section
    ) {
        return getStartedSectionRepository.save(section);
    }

    public List<GetStartedSection> getGetStartedSections() {
        return getStartedSectionRepository.findAll();
    }

    public GetStartedSection updateGetStarted(
            Long id,
            GetStartedSection updated
    ) {

        GetStartedSection section =
                getStartedSectionRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Section not found"));
        section.setId(updated.getId());
        section.setCardTitle(updated.getCardTitle()); 
        section.setHeading(updated.getHeading());
        section.setSubHeading(updated.getSubHeading());

        section.setPrimaryButtonText(
                updated.getPrimaryButtonText()
        );

        section.setPrimaryButtonUrl(
                updated.getPrimaryButtonUrl()
        );

        section.setSecondaryButtonText(
                updated.getSecondaryButtonText()
        );

        section.setSecondaryButtonUrl(
                updated.getSecondaryButtonUrl()
        );

        return getStartedSectionRepository.save(section);
    }

    public String deleteGetStarted(Long id) {

        getStartedSectionRepository.deleteById(id);

        return "Get Started section deleted successfully";
    }
 // =========================================
 // SITE SETTINGS
 // =========================================

 public List<SiteSettings> getSiteSettings() {
     return siteSettingsRepository.findAll();
 }

 public SiteSettings createSiteSettings(
         SiteSettings settings) {

     settings.setId(null);

     return siteSettingsRepository.save(settings);
 }

 public SiteSettings updateSiteSettings(
         Long id,
         SiteSettings updated) {

     SiteSettings existing =
             siteSettingsRepository.findById(id)
                     .orElseThrow(() ->
                             new RuntimeException("Site settings not found"));

     existing.setCompanyName(
             updated.getCompanyName());

     existing.setLogoUrl(
             updated.getLogoUrl());

     existing.setFaviconUrl(
             updated.getFaviconUrl());

     return siteSettingsRepository.save(existing);
 }

 public void deleteSiteSettings(Long id) {
     siteSettingsRepository.deleteById(id);
 }
}