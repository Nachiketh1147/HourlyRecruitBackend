package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/process")
public class ProcessAdminController {

    @Autowired
    private ProcessService service;

    // SECTION

    @PostMapping("/section")
    public ProcessSection createSection(
            @RequestBody ProcessSection section
    ) {
        return service.createSection(section);
    }

    @GetMapping("/section")
    public List<ProcessSection> getSections() {
        return service.getSections();
    }
    @PutMapping("/section/{id}")
    public ProcessSection updateSection(
            @PathVariable Long id,
            @RequestBody ProcessSection section
    ) {
        return service.updateSection(id, section);
    }

    @DeleteMapping("/section/{id}")
    public String deleteSection(
            @PathVariable Long id
    ) {
        service.deleteSection(id);
        return "Section deleted successfully";
    }

    // STEP

    @PostMapping("/step")
    public ProcessStep createStep(
            @RequestBody ProcessStep step
    ) {
        return service.createStep(step);
    }

    @GetMapping("/step/{sectionId}")
    public List<ProcessStep> getSteps(
            @PathVariable Long sectionId
    ) {
        return service.getSteps(sectionId);
    }
    @PutMapping("/step/{id}")
    public ProcessStep updateStep(
            @PathVariable Long id,
            @RequestBody ProcessStep step
    ) {
        return service.updateStep(id, step);
    }

    @DeleteMapping("/step/{id}")
    public String deleteStep(
            @PathVariable Long id
    ) {
        service.deleteStep(id);
        return "Step deleted successfully";
    }

    // POINT

    @PostMapping("/point")
    public ProcessPoint createPoint(
            @RequestBody ProcessPoint point
    ) {
        return service.createPoint(point);
    }

    @GetMapping("/point/{stepId}")
    public List<ProcessPoint> getPoints(
            @PathVariable Long stepId
    ) {
        return service.getPoints(stepId);
    }
    @PutMapping("/point/{id}")
    public ProcessPoint updatePoint(
            @PathVariable Long id,
            @RequestBody ProcessPoint point
    ) {
        return service.updatePoint(id, point);
    }

    @DeleteMapping("/point/{id}")
    public String deletePoint(
            @PathVariable Long id
    ) {
        service.deletePoint(id);
        return "Point deleted successfully";
    }
}