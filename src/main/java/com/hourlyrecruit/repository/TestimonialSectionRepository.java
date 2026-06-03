package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.TestimonialSection;

@Repository
public interface TestimonialSectionRepository
        extends JpaRepository<TestimonialSection, Long> {
}
