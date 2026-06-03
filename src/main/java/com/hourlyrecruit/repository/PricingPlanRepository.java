package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.PricingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricingPlanRepository
        extends JpaRepository<PricingPlan, Long> {

    List<PricingPlan> findBySectionId(Long sectionId);
}