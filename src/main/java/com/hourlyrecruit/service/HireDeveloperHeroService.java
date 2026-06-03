package com.hourlyrecruit.service;

import com.hourlyrecruit.model.HireDeveloperHero;
import com.hourlyrecruit.repository.HireDeveloperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireDeveloperHeroService {

    @Autowired
    private HireDeveloperHeroRepository repository;

    // CREATE

    public HireDeveloperHero createHero(
            HireDeveloperHero hero
    ) {
        return repository.save(hero);
    }

    // GET ALL

    public List<HireDeveloperHero> getAllHeroes() {
        return repository.findAll();
    }

    // GET BY ID

    public HireDeveloperHero getHeroById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    // UPDATE

    public HireDeveloperHero updateHero(
            Long id,
            HireDeveloperHero updatedHero
    ) {

        HireDeveloperHero hero =
                repository.findById(id).orElseThrow();

        hero.setBadgeTitle(updatedHero.getBadgeTitle());
        hero.setHeading(updatedHero.getHeading());
        hero.setSubHeading(updatedHero.getSubHeading());
        hero.setPrimaryButtonText(updatedHero.getPrimaryButtonText());
        hero.setPrimaryButtonUrl(updatedHero.getPrimaryButtonUrl());
        hero.setSecondaryButtonText(updatedHero.getSecondaryButtonText());
        hero.setSecondaryButtonUrl(updatedHero.getSecondaryButtonUrl());

        return repository.save(hero);
    }

    // DELETE

    public void deleteHero(Long id) {
        repository.deleteById(id);
    }
}