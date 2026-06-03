package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.ContactMessageSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageSectionRepository
        extends JpaRepository<ContactMessageSection, Long> {

    ContactMessageSection findBySectionName(String sectionName);
}