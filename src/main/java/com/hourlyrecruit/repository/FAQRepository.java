package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.FAQ;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
}