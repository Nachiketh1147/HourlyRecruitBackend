package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.PricingSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingSectionRepository
        extends JpaRepository<PricingSection, Long> {
}