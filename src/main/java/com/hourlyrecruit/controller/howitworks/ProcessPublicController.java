package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.dto.ProcessSectionResponse;
import com.hourlyrecruit.model.*;
import com.hourlyrecruit.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/process")
public class ProcessPublicController {

    @Autowired
    private ProcessService service;

    @GetMapping("/section")
    public List<ProcessSection> getSections() {
        return service.getSections();
    }

    @GetMapping("/step/{sectionId}")
    public List<ProcessStep> getSteps(
            @PathVariable Long sectionId
    ) {
        return service.getSteps(sectionId);
    }

    @GetMapping("/point/{stepId}")
    public List<ProcessPoint> getPoints(
            @PathVariable Long stepId
    ) {
        return service.getPoints(stepId);
    }
    @GetMapping("/full/{sectionId}")
    public ProcessSectionResponse getFullProcess(
            @PathVariable Long sectionId
    ) {
        return service.getFullProcessSection(sectionId);
    }
}