package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.StartupSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartupSectionRepository
        extends JpaRepository<StartupSection, Long> {
}