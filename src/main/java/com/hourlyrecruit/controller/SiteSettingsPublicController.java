package com.hourlyrecruit.controller;

import com.hourlyrecruit.model.SiteSettings;
import com.hourlyrecruit.service.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/site-settings")
public class SiteSettingsPublicController {

    @Autowired
    private AboutService aboutService;

    @GetMapping
    public SiteSettings getSettings() {

        return aboutService.getSiteSettings()
                .stream()
                .findFirst()
                .orElse(null);
    }
}