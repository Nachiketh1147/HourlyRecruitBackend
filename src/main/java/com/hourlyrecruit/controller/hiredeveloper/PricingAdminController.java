package com.hourlyrecruit.controller.hiredeveloper;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/pricing")
public class PricingAdminController {

    @Autowired
    private PricingService pricingService;

    // SECTION

    @PostMapping("/section")
    public PricingSection createSection(
            @RequestBody PricingSection section
    ) {
        return pricingService.createSection(section);
    }

    @PutMapping("/section/{id}")
    public PricingSection updateSection(
            @PathVariable Long id,
            @RequestBody PricingSection section
    ) {
        return pricingService.updateSection(id, section);
    }

    @DeleteMapping("/section/{id}")
    public void deleteSection(@PathVariable Long id) {
        pricingService.deleteSection(id);
    }

    // PLAN

    @PostMapping("/plan")
    public PricingPlan createPlan(
            @RequestBody PricingPlan plan
    ) {
        return pricingService.createPlan(plan);
    }

    @PutMapping("/plan/{id}")
    public PricingPlan updatePlan(
            @PathVariable Long id,
            @RequestBody PricingPlan plan
    ) {
        return pricingService.updatePlan(id, plan);
    }

    @DeleteMapping("/plan/{id}")
    public void deletePlan(@PathVariable Long id) {
        pricingService.deletePlan(id);
    }

    // FEATURE

    @PostMapping("/feature")
    public PricingFeature createFeature(
            @RequestBody PricingFeature feature
    ) {
        return pricingService.createFeature(feature);
    }

    @PutMapping("/feature/{id}")
    public PricingFeature updateFeature(
            @PathVariable Long id,
            @RequestBody PricingFeature feature
    ) {
        return pricingService.updateFeature(id, feature);
    }

    @DeleteMapping("/feature/{id}")
    public void deleteFeature(@PathVariable Long id) {
        pricingService.deleteFeature(id);
    }
}