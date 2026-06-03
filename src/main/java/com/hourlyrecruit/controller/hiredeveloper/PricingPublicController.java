package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.dto.PricingResponseDto;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/pricing")
public class PricingPublicController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/sections")
    public List<PricingSection> getSections() {
        return pricingService.getAllSections();
    }

    @GetMapping("/plans/{sectionId}")
    public List<PricingPlan> getPlans(
            @PathVariable Long sectionId
    ) {
        return pricingService.getPlansBySection(sectionId);
    }

    @GetMapping("/features/{planId}")
    public List<PricingFeature> getFeatures(
            @PathVariable Long planId
    ) {
        return pricingService.getFeaturesByPlan(planId);
    }
    @GetMapping("/{sectionId}")
    public PricingResponseDto getPricing(
            @PathVariable Long sectionId
    ) {
        return pricingService.getCompletePricing(sectionId);
    }
}