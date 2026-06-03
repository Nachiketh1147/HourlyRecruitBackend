package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.*;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutHowItWorksService {

    @Autowired
    private AboutHowItWorksSectionRepository sectionRepository;

    @Autowired
    private AboutHowItWorksStepRepository stepRepository;

    // SECTION CRUD

    public AboutHowItWorksSection createSection(AboutHowItWorksSection section) {
        return sectionRepository.save(section);
    }

    public AboutHowItWorksSection updateSection(Long id,AboutHowItWorksSection updated) {

        AboutHowItWorksSection section = sectionRepository.findById(id).orElseThrow();

        section.setCardTitle(updated.getCardTitle());
        section.setHeading(updated.getHeading());
        section.setSubHeading(updated.getSubHeading());

        return sectionRepository.save(section);
    }

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // STEP CRUD

    public AboutHowItWorksStep createStep(
            AboutHowItWorksStep step
    ) {

        Long sectionId = step.getSection().getId();

        AboutHowItWorksSection section = sectionRepository
                .findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        step.setSection(section);

        AboutHowItWorksStep saved = stepRepository.save(step);

        return stepRepository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Step not found after save"));
    }

    public AboutHowItWorksStep updateStep(
            Long id,
            AboutHowItWorksStep updated
    ) {

        AboutHowItWorksStep step = stepRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Step not found"));

        step.setStepNumber(updated.getStepNumber());
        step.setTitle(updated.getTitle());
        step.setDescription(updated.getDescription());

        if (updated.getSection() != null &&
                updated.getSection().getId() != null) {

            AboutHowItWorksSection section = sectionRepository
                    .findById(updated.getSection().getId())
                    .orElseThrow(() -> new RuntimeException("Section not found"));

            step.setSection(section);
        }

        return stepRepository.save(step);
    }
    public void deleteStep(Long id) {
        stepRepository.deleteById(id);
    }

    // COMPLETE RESPONSE

    public AboutHowItWorksResponseDto getCompleteSection(Long sectionId) {

        AboutHowItWorksSection section = sectionRepository.findById(sectionId).orElseThrow();

        AboutHowItWorksResponseDto response = new AboutHowItWorksResponseDto();

        response.setId(section.getId());
        response.setCardTitle(section.getCardTitle());
        response.setHeading(section.getHeading());
        response.setSubHeading(section.getSubHeading());

        List<AboutHowItWorksStepDto> stepDtos = stepRepository.findBySectionId(sectionId)
                        .stream()
                        .map(step -> {

                            AboutHowItWorksStepDto dto = new AboutHowItWorksStepDto();

                            dto.setId(step.getId());
                            dto.setStepNumber(step.getStepNumber());
                            dto.setTitle(step.getTitle());
                            dto.setDescription(step.getDescription());

                            return dto;

                        }).toList();

        response.setSteps(stepDtos);

        return response;
    }
}