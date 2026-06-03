package com.hourlyrecruit.service;

import com.hourlyrecruit.dto.ProcessSectionResponse;
import com.hourlyrecruit.dto.ProcessStepResponse;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    @Autowired
    private ProcessSectionRepository sectionRepository;

    @Autowired
    private ProcessStepRepository stepRepository;

    @Autowired
    private ProcessPointRepository pointRepository;

    // SECTION CRUD

    public ProcessSection createSection(ProcessSection section) {
        return sectionRepository.save(section);
    }

    public List<ProcessSection> getSections() {
        return sectionRepository.findAll();
    }

    // STEP CRUD

    public ProcessStep createStep(ProcessStep step) {
        return stepRepository.save(step);
    }

    public List<ProcessStep> getSteps(Long sectionId) {
        return stepRepository.findBySectionIdOrderByStepNumberAsc(sectionId);
    }

    // POINT CRUD

    public ProcessPoint createPoint(ProcessPoint point) {
        return pointRepository.save(point);
    }

    public List<ProcessPoint> getPoints(Long stepId) {
        return pointRepository.findByStepId(stepId);
    }
 // ================= UPDATE SECTION =================

    public ProcessSection updateSection(
            Long id,
            ProcessSection updatedSection
    ) {
        ProcessSection section = sectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        section.setCardTitle(updatedSection.getCardTitle());
        section.setHeading(updatedSection.getHeading());
        section.setSubHeading(updatedSection.getSubHeading());

        return sectionRepository.save(section);
    }

    // ================= DELETE SECTION =================

    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    // ================= UPDATE STEP =================

    public ProcessStep updateStep(
            Long id,
            ProcessStep updatedStep
    ) {
        ProcessStep step = stepRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Step not found"));

        step.setStepNumber(updatedStep.getStepNumber());
        step.setTitle(updatedStep.getTitle());
        step.setDescription(updatedStep.getDescription());

        return stepRepository.save(step);
    }

    // ================= DELETE STEP =================

    public void deleteStep(Long id) {
        stepRepository.deleteById(id);
    }

    // ================= UPDATE POINT =================

    public ProcessPoint updatePoint(
            Long id,
            ProcessPoint updatedPoint
    ) {
        ProcessPoint point = pointRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point not found"));

        point.setPoint(updatedPoint.getPoint());

        return pointRepository.save(point);
    }

    // ================= DELETE POINT =================

    public void deletePoint(Long id) {
        pointRepository.deleteById(id);
    }
    public ProcessSectionResponse getFullProcessSection(Long sectionId) {

        ProcessSection section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        List<ProcessStep> steps =
                stepRepository.findBySectionIdOrderByStepNumberAsc(sectionId);

        List<ProcessStepResponse> stepResponses = steps.stream().map(step -> {

            List<String> points = pointRepository.findByStepId(step.getId())
                    .stream()
                    .map(ProcessPoint::getPoint)
                    .toList();

            return new ProcessStepResponse(
                    step.getId(),
                    step.getStepNumber(),
                    step.getTitle(),
                    step.getDescription(),
                    points
            );

        }).toList();

        return new ProcessSectionResponse(
                section.getId(),
                section.getCardTitle(),
                section.getHeading(),
                section.getSubHeading(),
                stepResponses
        );
    }
}