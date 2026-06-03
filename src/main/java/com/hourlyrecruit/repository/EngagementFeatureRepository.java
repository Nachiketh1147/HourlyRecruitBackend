package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.EngagementFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngagementFeatureRepository
        extends JpaRepository<EngagementFeature, Long> {

    List<EngagementFeature> findByModelId(Long modelId);
}