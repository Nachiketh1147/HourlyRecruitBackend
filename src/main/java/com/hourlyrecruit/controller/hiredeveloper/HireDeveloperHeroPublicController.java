package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.model.HireDeveloperHero;
import com.hourlyrecruit.service.HireDeveloperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/hire-developer-hero")
public class HireDeveloperHeroPublicController { 

    @Autowired
    private HireDeveloperHeroService service;

    // GET ALL

    @GetMapping
    public List<HireDeveloperHero> getAllHeroes() {
        return service.getAllHeroes();
    }

    // GET BY ID

    @GetMapping("/{id}")
    public HireDeveloperHero getHeroById(
            @PathVariable Long id
    ) {
        return service.getHeroById(id);
    }
}