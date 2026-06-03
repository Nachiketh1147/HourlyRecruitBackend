package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.PricingFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricingFeatureRepository
        extends JpaRepository<PricingFeature, Long> {

    List<PricingFeature> findByPlanId(Long planId);
}