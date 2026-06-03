package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.AboutHeroSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutHeroRepository
        extends JpaRepository<AboutHeroSection, Long> {
}