package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository
        extends JpaRepository<Testimonial, Long> {
}