package com.hourlyrecruit.controller.technologies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hourlyrecruit.model.Technology;
import com.hourlyrecruit.model.TechnologyCTA;
import com.hourlyrecruit.model.TechnologyCategory;
import com.hourlyrecruit.model.TechnologyHeroSection;
import com.hourlyrecruit.service.TechnologyService;

@RestController
@RequestMapping("/public/technologies")
public class TechnologyPublicController {

    @Autowired
    private TechnologyService technologyService;

    // HERO SECTION
    @GetMapping("/hero")
    public ResponseEntity<List<TechnologyHeroSection>> getSections() {
        return ResponseEntity.ok(technologyService.getSections());  
    }


    @GetMapping("/categories")
    public List<TechnologyCategory> getAllCategories() {
        return technologyService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public TechnologyCategory getCategoryById(@PathVariable Long id) {
        return technologyService.getCategoryById(id);
    }

    @GetMapping("/categories/{id}/items")
    public List<Technology> getTechnologiesByCategory(@PathVariable Long id) {
        return technologyService.getTechnologiesByCategory(id);
    }

    // CTA SECTION
    @GetMapping("/cta")
    public ResponseEntity<List<TechnologyCTA>> getCTASection() {
        return ResponseEntity.ok(technologyService.getCTA());  
    }
}