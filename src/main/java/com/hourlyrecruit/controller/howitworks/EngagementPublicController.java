package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.dto.EngagementSectionDTO;
import com.hourlyrecruit.model.EngagementFeature;
import com.hourlyrecruit.model.EngagementModel;
import com.hourlyrecruit.model.EngagementSection;
import com.hourlyrecruit.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/engagement")
public class EngagementPublicController {

    @Autowired
    private EngagementService service;

    // SECTION

    @GetMapping("/section/all")
    public List<EngagementSection> getAllSections() {
        return service.getAllSections();
    }

    // MODELS

    @GetMapping("/model/section/{sectionId}")
    public List<EngagementModel> getModelsBySection(
            @PathVariable Long sectionId
    ) {
        return service.getModelsBySection(sectionId);
    }

    // FEATURES

    @GetMapping("/feature/model/{modelId}")
    public List<EngagementFeature> getFeaturesByModel(
            @PathVariable Long modelId
    ) {
        return service.getFeaturesByModel(modelId);
    }
    @GetMapping("/complete/{sectionId}")
    public EngagementSectionDTO getCompleteSection(
            @PathVariable Long sectionId
    ) {
        return service.getCompleteSection(sectionId);
    }
}