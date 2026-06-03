package com.hourlyrecruit.controller.footer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hourlyrecruit.dto.FooterResponseDTO;
import com.hourlyrecruit.service.FooterService;

@RestController
@RequestMapping("/public/footer")
public class FooterPublicController {

    @Autowired
    private FooterService footerService;

    @GetMapping
    public FooterResponseDTO getFooter() {
        return footerService.getFooterData();
    }
}