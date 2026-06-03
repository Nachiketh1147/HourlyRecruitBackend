package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.ProcessSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessSectionRepository
        extends JpaRepository<ProcessSection, Long> {
}