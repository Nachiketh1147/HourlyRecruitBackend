package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.HireDeveloperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HireDeveloperHeroRepository
        extends JpaRepository<HireDeveloperHero, Long> {
}