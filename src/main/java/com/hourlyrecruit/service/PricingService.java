package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.PricingFeatureDto;
import com.hourlyrecruit.dto.PricingPlanDto;
import com.hourlyrecruit.dto.PricingResponseDto;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingSectionRepository sectionRepository;

    @Autowired
    private PricingPlanRepository planRepository;

    @Autowired
    private PricingFeatureRepository featureRepository;

    // SECTION CRUD

    public PricingSection createSection(PricingSection section) {
        return sectionRepository.save(section);
    }

    public List<PricingSection> getAllSections() {
        return sectionRepository.findAll();
    }

    public PricingSection updateSection(Long id, PricingSection updated) {

        PricingSection section =
                sectionRepository.findById(id).orElseThrow();

        section.setCardTitle(updated.getCardTitle());
        section.setHeading(updated.getHeading());
        section.setSubHeading(updated.getSubHeading());

        return sectionRepository.save(section);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // PLAN CRUD

    public PricingPlan createPlan(PricingPlan plan) {
        return planRepository.save(plan);
    }

    public List<PricingPlan> getPlansBySection(Long sectionId) {
        return planRepository.findBySectionId(sectionId);
    }

    public PricingPlan updatePlan(
            Long id,
            PricingPlan updated
    ) {

        PricingPlan plan = planRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pricing plan not found"));

        plan.setType(updated.getType());
        plan.setTitle(updated.getTitle());
        plan.setBadge(updated.getBadge());
        plan.setPrice(updated.getPrice());
        plan.setDescription(updated.getDescription());
        plan.setButtonText(updated.getButtonText());
        plan.setButtonTextUrl(updated.getButtonTextUrl());

        // Update Section
        if (updated.getSection() != null &&
            updated.getSection().getId() != null) {

            PricingSection section = sectionRepository
                    .findById(updated.getSection().getId())
                    .orElseThrow(() ->
                            new RuntimeException("Pricing section not found"));

            plan.setSection(section);
        }

        return planRepository.save(plan);
    }
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    // FEATURE CRUD

 
    public PricingFeature createFeature(PricingFeature feature) {

        Long planId = feature.getPlan().getId();

        PricingPlan plan = planRepository.findById(planId)
                .orElseThrow(() ->
                        new RuntimeException("Plan not found"));

        feature.setPlan(plan);

        return featureRepository.save(feature);
    }

    public List<PricingFeature> getFeaturesByPlan(Long planId) {
        return featureRepository.findByPlanId(planId);
    }

    public PricingFeature updateFeature(
            Long id,
            PricingFeature updated
    ) {

        PricingFeature feature = featureRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Feature not found"));

        feature.setFeature(updated.getFeature());

        if (updated.getPlan() != null &&
                updated.getPlan().getId() != null) {

            PricingPlan plan = planRepository
                    .findById(updated.getPlan().getId())
                    .orElseThrow(() ->
                            new RuntimeException("Plan not found"));

            feature.setPlan(plan);
        }

        return featureRepository.save(feature);
    }

    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
    public PricingResponseDto getCompletePricing(Long sectionId) {

        PricingSection section =
                sectionRepository.findById(sectionId).orElseThrow();

        PricingResponseDto response = new PricingResponseDto();

        response.setId(section.getId());
        response.setCardTitle(section.getCardTitle());
        response.setHeading(section.getHeading());
        response.setSubHeading(section.getSubHeading());

        List<PricingPlan> plans =
                planRepository.findBySectionId(sectionId);

        List<PricingPlanDto> planDtos = plans.stream().map(plan -> {

            PricingPlanDto dto = new PricingPlanDto();

            dto.setId(plan.getId());
            dto.setType(plan.getType().name());
            dto.setTitle(plan.getTitle());
            dto.setBadge(plan.getBadge());
            dto.setPrice(plan.getPrice());
            dto.setDescription(plan.getDescription());
            dto.setButtonText(plan.getButtonText());
            dto.setButtonTextUrl(plan.getButtonTextUrl());

            List<PricingFeatureDto> featureDtos =
                    featureRepository.findByPlanId(plan.getId())
                            .stream()
                            .map(feature -> {

                                PricingFeatureDto f =
                                        new PricingFeatureDto();

                                f.setId(feature.getId());
                                f.setFeature(feature.getFeature());

                                return f;
                            }).toList();

            dto.setFeatures(featureDtos);

            return dto;

        }).toList();

        response.setPlans(planDtos);

        return response;
    }
}