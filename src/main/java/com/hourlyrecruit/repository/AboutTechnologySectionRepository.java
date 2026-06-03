package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.AboutTechnologySection;

@Repository
public interface AboutTechnologySectionRepository
        extends JpaRepository<AboutTechnologySection, Long> {
}