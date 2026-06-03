package com.hourlyrecruit.controller;

import com.hourlyrecruit.model.SiteSettings;
import com.hourlyrecruit.service.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/site-settings")
public class SiteSettingsAdminController {

    @Autowired
    private AboutService aboutService;

    @GetMapping
    public List<SiteSettings> getAll() {
        return aboutService.getSiteSettings();
    }

    @PostMapping
    public SiteSettings create(
            @RequestBody SiteSettings settings) {

        return aboutService.createSiteSettings(settings);
    }

    @PutMapping("/{id}")
    public SiteSettings update(
            @PathVariable Long id,
            @RequestBody SiteSettings settings) {

        return aboutService.updateSiteSettings(id, settings);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        aboutService.deleteSiteSettings(id);
    }
}