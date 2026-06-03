package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.IndustrySection;

@Repository
public interface IndustrySectionRepository
        extends JpaRepository<IndustrySection, Long> {
}