package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.WhyChooseUsSection;

@Repository
public interface WhyChooseUsSectionRepository
        extends JpaRepository<WhyChooseUsSection, Long> {
}