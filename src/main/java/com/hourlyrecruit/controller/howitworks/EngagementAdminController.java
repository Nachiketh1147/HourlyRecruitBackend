package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.EngagementFeature;
import com.hourlyrecruit.model.EngagementModel;
import com.hourlyrecruit.model.EngagementSection;
import com.hourlyrecruit.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/engagement")
public class EngagementAdminController {

    @Autowired
    private EngagementService service;

    // =====================================================
    // SECTION APIs
    // =====================================================

    @PostMapping("/section/create")
    public EngagementSection createSection(
            @RequestBody EngagementSection section
    ) {
        return service.createSection(section);
    }

    @GetMapping("/section/all")
    public List<EngagementSection> getAllSections() {
        return service.getAllSections();
    }

    @PutMapping("/section/update/{id}")
    public EngagementSection updateSection(
            @PathVariable Long id,
            @RequestBody EngagementSection section
    ) {
        return service.updateSection(id, section);
    }

    @DeleteMapping("/section/delete/{id}")
    public String deleteSection(
            @PathVariable Long id
    ) {
        service.deleteSection(id);
        return "Section deleted successfully";
    }

    // =====================================================
    // MODEL APIs
    // =====================================================

    @PostMapping("/model/create")
    public EngagementModel createModel(
            @RequestBody EngagementModel model
    ) {
        return service.createModel(model);
    }

    @GetMapping("/model/all")
    public List<EngagementModel> getAllModels() {
        return service.getAllModels();
    }

    @GetMapping("/model/section/{sectionId}")
    public List<EngagementModel> getModelsBySection(
            @PathVariable Long sectionId
    ) {
        return service.getModelsBySection(sectionId);
    }

    @PutMapping("/model/update/{id}")
    public EngagementModel updateModel(
            @PathVariable Long id,
            @RequestBody EngagementModel model
    ) {
        return service.updateModel(id, model);
    }

    @DeleteMapping("/model/delete/{id}")
    public String deleteModel(
            @PathVariable Long id
    ) {
        service.deleteModel(id);
        return "Model deleted successfully";
    }

    // =====================================================
    // FEATURE APIs
    // =====================================================

    @PostMapping("/feature/create")
    public EngagementFeature createFeature(
            @RequestBody EngagementFeature feature
    ) {
        return service.createFeature(feature);
    }

    @GetMapping("/feature/all")
    public List<EngagementFeature> getAllFeatures() {
        return service.getAllFeatures();
    }

    @GetMapping("/feature/model/{modelId}")
    public List<EngagementFeature> getFeaturesByModel(
            @PathVariable Long modelId
    ) {
        return service.getFeaturesByModel(modelId);
    }

    @PutMapping("/feature/update/{id}")
    public EngagementFeature updateFeature(
            @PathVariable Long id,
            @RequestBody EngagementFeature feature
    ) {
        return service.updateFeature(id, feature);
    }

    @DeleteMapping("/feature/delete/{id}")
    public String deleteFeature(
            @PathVariable Long id
    ) {
        service.deleteFeature(id);
        return "Feature deleted successfully";
    }
}