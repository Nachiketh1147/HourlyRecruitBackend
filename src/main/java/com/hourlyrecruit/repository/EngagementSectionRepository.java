package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.EngagementSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngagementSectionRepository
        extends JpaRepository<EngagementSection, Long> {
}