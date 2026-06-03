package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.model.HireDeveloperHero;
import com.hourlyrecruit.service.HireDeveloperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hire-developer-hero")
public class HireDeveloperHeroAdminController {

    @Autowired
    private HireDeveloperHeroService service;

    // CREATE

    @PostMapping
    public HireDeveloperHero createHero(
            @RequestBody HireDeveloperHero hero
    ) {
        return service.createHero(hero);
    }

    // UPDATE

    @PutMapping("/{id}")
    public HireDeveloperHero updateHero(
            @PathVariable Long id,
            @RequestBody HireDeveloperHero hero
    ) {
        return service.updateHero(id, hero);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public void deleteHero(
            @PathVariable Long id
    ) {
        service.deleteHero(id);
    }
}