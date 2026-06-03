package com.hourlyrecruit.controller.technologies;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/technologies")
public class TechnologyAdminController {
	@Autowired
    private TechnologyService technologyService;

    // TECHNOLOGY CRUD
    // CATEGORY

    @PostMapping("/categories")
    public TechnologyCategory createCategory(
            @RequestBody TechnologyCategory category
    ) {
        return technologyService.createCategory(category);
    }

    @PutMapping("/categories/{id}")
    public TechnologyCategory updateCategory(
            @PathVariable Long id,
            @RequestBody TechnologyCategory category
    ) {
        return technologyService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        technologyService.deleteCategory(id);
    }

    // TECHNOLOGY

    @PostMapping("/categories/{categoryId}/items")
    public Technology addTechnology(
            @PathVariable Long categoryId,
            @RequestBody Technology technology
    ) {
        return technologyService.addTechnology(
                categoryId,
                technology 
        );
    }

    @PutMapping("/items/{technologyId}")
    public Technology updateTechnology(
            @PathVariable Long technologyId,
            @RequestBody Technology technology
    ) {
        return technologyService.updateTechnology(
                technologyId,
                technology
        );
    }

    @DeleteMapping("/items/{technologyId}")
    public void deleteTechnology(
            @PathVariable Long technologyId
    ) {
        technologyService.deleteTechnology(technologyId);
    }

    // HERO SECTION

    @PostMapping("/hero")
    public ResponseEntity<TechnologyHeroSection> saveSection(@RequestBody TechnologyHeroSection section) {
        return ResponseEntity.ok(technologyService.saveSection(section));
    }

    @PutMapping("/hero/{id}")
    public ResponseEntity<TechnologyHeroSection> updateHeroSection(@PathVariable Long id,@RequestBody TechnologyHeroSection hero) {
        return ResponseEntity.ok(technologyService.updateSection(id, hero)); 
    }

    @DeleteMapping("/hero/{id}")
    public ResponseEntity<String> deleteHeroSection(@PathVariable Long id) {
    	return ResponseEntity.ok(technologyService.deleteSection(id)); 
    } 

    // CTA

    @PostMapping("/cta")
    public ResponseEntity<TechnologyCTA> saveCTA(@RequestBody TechnologyCTA cta) {
        return ResponseEntity.ok(technologyService.saveCTA(cta));
    }
    @PutMapping("/cta/{id}")
    public ResponseEntity<TechnologyCTA> updateCTA(@PathVariable Long id,@RequestBody TechnologyCTA cta) {
        return ResponseEntity.ok(technologyService.updateCTA(id, cta));
    }

    @DeleteMapping("/cta/{id}")
    public ResponseEntity<String> deleteCTA(@PathVariable Long id) {
    	return ResponseEntity.ok(technologyService.deleteCTA(id));
    }
} 