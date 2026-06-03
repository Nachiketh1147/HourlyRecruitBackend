package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.EngagementModelDTO;
import com.hourlyrecruit.dto.EngagementSectionDTO;
import com.hourlyrecruit.model.EngagementFeature;
import com.hourlyrecruit.model.EngagementModel;
import com.hourlyrecruit.model.EngagementSection;
import com.hourlyrecruit.repository.EngagementFeatureRepository;
import com.hourlyrecruit.repository.EngagementModelRepository;
import com.hourlyrecruit.repository.EngagementSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngagementService {

    @Autowired
    private EngagementSectionRepository sectionRepository;

    @Autowired
    private EngagementModelRepository modelRepository;

    @Autowired
    private EngagementFeatureRepository featureRepository;

    // =====================================================
    // SECTION CRUD
    // =====================================================

    public EngagementSection createSection(
            EngagementSection section
    ) {
        return sectionRepository.save(section);
    }

    public List<EngagementSection> getAllSections() {
        return sectionRepository.findAll();
    }

    public EngagementSection getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));
    }

    public EngagementSection updateSection(
            Long id,
            EngagementSection updated
    ) {

        EngagementSection existing = getSectionById(id);

        existing.setCardTitle(updated.getCardTitle());
        existing.setHeading(updated.getHeading());
        existing.setSubHeading(updated.getSubHeading());

        return sectionRepository.save(existing);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // =====================================================
    // MODEL CRUD
    // =====================================================

    public EngagementModel createModel(EngagementModel model) {

        Long sectionId = model.getSection().getId();

        EngagementSection section = sectionRepository
                .findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        model.setSection(section);

        EngagementModel saved = modelRepository.save(model);

        return modelRepository.findById(saved.getId())
                .orElseThrow();
    }

    public List<EngagementModel> getAllModels() {
        return modelRepository.findAll();
    }

    public List<EngagementModel> getModelsBySection(
            Long sectionId
    ) {
        return modelRepository.findBySectionId(sectionId);
    }

    public EngagementModel getModelById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found"));
    }

    public EngagementModel updateModel(
            Long id,
            EngagementModel updated
    ) {

        EngagementModel existing = getModelById(id);

        existing.setTitle(updated.getTitle());
        existing.setImgUrl(updated.getImgUrl());
        existing.setBadge(updated.getBadge());
        existing.setDescription(updated.getDescription());

        return modelRepository.save(existing);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    // =====================================================
    // FEATURE CRUD
    // =====================================================

    public EngagementFeature createFeature(
            EngagementFeature feature
    ) {

        Long modelId = feature.getModel().getId();

        EngagementModel model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        feature.setModel(model);

        return featureRepository.save(feature);
    }

    public List<EngagementFeature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public List<EngagementFeature> getFeaturesByModel(
            Long modelId
    ) {
        return featureRepository.findByModelId(modelId);
    }

    public EngagementFeature updateFeature(
            Long id,
            EngagementFeature updated
    ) {

        EngagementFeature existing = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found"));

        existing.setFeature(updated.getFeature());

        if(updated.getModel() != null) {
            EngagementModel model = modelRepository.findById(
                    updated.getModel().getId()
            ).orElseThrow(() -> new RuntimeException("Model not found"));

            existing.setModel(model);
        }

        return featureRepository.save(existing);
    }
    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
    public EngagementSectionDTO getCompleteSection(Long sectionId) {

        EngagementSection section = getSectionById(sectionId);

        EngagementSectionDTO sectionDTO = new EngagementSectionDTO();

        sectionDTO.setId(section.getId());
        sectionDTO.setCardTitle(section.getCardTitle());
        sectionDTO.setHeading(section.getHeading());
        sectionDTO.setSubHeading(section.getSubHeading());

        List<EngagementModel> models =
                modelRepository.findBySectionId(sectionId);

        List<EngagementModelDTO> modelDTOList = models.stream().map(model -> {

            EngagementModelDTO modelDTO = new EngagementModelDTO();

            modelDTO.setId(model.getId());
            modelDTO.setTitle(model.getTitle());
            modelDTO.setImgUrl(model.getImgUrl());
            modelDTO.setBadge(model.getBadge());
            modelDTO.setDescription(model.getDescription());

            List<String> features =
                    featureRepository.findByModelId(model.getId())
                            .stream()
                            .map(feature -> feature.getFeature())
                            .toList();

            modelDTO.setFeatures(features);

            return modelDTO;

        }).toList();

        sectionDTO.setModels(modelDTOList);

        return sectionDTO;
    }
}