package com.hourlyrecruit.service;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {
	@Autowired
    private TechnologyRepository technologyRepository;
	@Autowired
    private TechnologyHeroSectionRepository sectionRepository;
	@Autowired
    private TechnologyCTARepository ctaRepository;
	@Autowired
	private TechnologyCategoryRepository categoryRepository;
	    

	    // CATEGORY OPERATIONS

	    public List<TechnologyCategory> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    public TechnologyCategory getCategoryById(Long id) {
	        return categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	    }

	    public TechnologyCategory createCategory(
	            TechnologyCategory category
	    ) {
	        return categoryRepository.save(category);
	    }

	    public TechnologyCategory updateCategory(
	            Long id,
	            TechnologyCategory updatedCategory
	    ) {

	        TechnologyCategory category = getCategoryById(id);

	        category.setCategoryName(updatedCategory.getCategoryName());
	        category.setCategoryImage(updatedCategory.getCategoryImage());

	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }

	    // TECHNOLOGY OPERATIONS

	    public Technology addTechnology(
	            Long categoryId,
	            Technology technology
	    ) {

	        TechnologyCategory category =
	                getCategoryById(categoryId);

	        technology.setCategory(category);

	        return technologyRepository.save(technology);
	    }

	    public List<Technology> getTechnologiesByCategory(
	            Long categoryId
	    ) {
	        return technologyRepository.findByCategoryId(categoryId);
	    }

	    public Technology updateTechnology(
	            Long technologyId,
	            Technology updatedTechnology
	    ) {

	        Technology technology =
	                technologyRepository.findById(technologyId)
	                        .orElseThrow(() ->
	                                new RuntimeException("Technology not found"));

	        technology.setName(updatedTechnology.getName());
	        technology.setDescription(updatedTechnology.getDescription());

	        return technologyRepository.save(technology);
	    }

	    public void deleteTechnology(Long technologyId) {
	        technologyRepository.deleteById(technologyId);
	    }
	

    // HERO SECTION

    public TechnologyHeroSection saveSection(TechnologyHeroSection section) {
        return sectionRepository.save(section);
    }

    public List<TechnologyHeroSection> getSections() {
        return sectionRepository.findAll();
    }
    public String deleteSection(Long id) {
    	sectionRepository.deleteById(id);
    	return "Hero Section Deleted Successfully"; 
    }
    public TechnologyHeroSection updateSection( 
            Long id,
            TechnologyHeroSection updatedHero
    ) {

        TechnologyHeroSection hero =
                sectionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Hero section not found"));
        hero.setCardTitle(updatedHero.getCardTitle());
        hero.setHeading(updatedHero.getHeading());
        hero.setSubHeading(updatedHero.getSubHeading());

        return sectionRepository.save(hero);
    } 

    // CTA

    public TechnologyCTA saveCTA(TechnologyCTA cta) {
        return ctaRepository.save(cta);
    }

    public List<TechnologyCTA> getCTA() {
        return ctaRepository.findAll();
    }
    public String deleteCTA(Long id) {
    	ctaRepository.deleteById(id);
    	return "CTA Deleted Successfully"; 
    }
    public TechnologyCTA updateCTA(
            Long id,
            TechnologyCTA updatedCTA
    ) {

        TechnologyCTA cta =
                ctaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("CTA not found"));
        cta.setCardTitle(updatedCTA.getCardTitle());

        cta.setHeading(updatedCTA.getHeading()); 
        cta.setCardTitle(updatedCTA.getCardTitle());
        cta.setDescription(updatedCTA.getDescription());
        cta.setPrimaryButton(updatedCTA.getPrimaryButton());
        cta.setPrimaryButtonUrl(updatedCTA.getPrimaryButtonUrl());
        
        cta.setSecondaryButton(updatedCTA.getSecondaryButton());
        cta.setSecondaryButtonUrl(updatedCTA.getSecondaryButtonUrl()); 
 
        return ctaRepository.save(cta);
    }
}