package com.hourlyrecruit.controller.footer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hourlyrecruit.model.Footer;
import com.hourlyrecruit.model.FooterQuickLink;
import com.hourlyrecruit.service.FooterService;

@RestController
@RequestMapping("/admin/footer")
public class FooterAdminController {

    @Autowired
    private FooterService footerService;

    @PostMapping
    public Footer createFooter(
            @RequestBody Footer footer) {

        return footerService.save(footer);
    }

    @PutMapping("/{id}")
    public Footer updateFooter(
            @PathVariable Long id,
            @RequestBody Footer footer) {

        return footerService.update(id, footer);
    }

    @DeleteMapping("/{id}")
    public void deleteFooter(
            @PathVariable Long id) {

        footerService.deleteFooter(id);
    }

    @PostMapping("/quick-links")
    public FooterQuickLink createQuickLink(
            @RequestBody FooterQuickLink quickLink) {

        return footerService.saveQuickLink(quickLink);
    }

    @DeleteMapping("/quick-links/{id}")
    public void deleteQuickLink(
            @PathVariable Long id) {

        footerService.deleteQuickLink(id);
    }

    @PostMapping("/services")
    public com.hourlyrecruit.model.FooterServiceItem createService(
            @RequestBody com.hourlyrecruit.model.FooterServiceItem service) { 

        return footerService.saveFooterService(service);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(
            @PathVariable Long id) {

        footerService.deleteFooterService(id);
    }
}