package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.HireDeveloperSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HireDeveloperSectionRepository
        extends JpaRepository<HireDeveloperSection, Long> {
}