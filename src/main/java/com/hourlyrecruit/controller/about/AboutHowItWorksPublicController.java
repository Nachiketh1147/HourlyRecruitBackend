package com.hourlyrecruit.controller.about;

import com.hourlyrecruit.dto.AboutHowItWorksResponseDto;
import com.hourlyrecruit.service.AboutHowItWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/about/how-it-works")
public class AboutHowItWorksPublicController {

    @Autowired
    private AboutHowItWorksService service;

    @GetMapping("/{sectionId}")
    public AboutHowItWorksResponseDto getCompleteSection(
            @PathVariable Long sectionId
    ) {
        return service.getCompleteSection(sectionId);
    }
}