package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.ReadySection;
import com.hourlyrecruit.model.FAQ;
import com.hourlyrecruit.service.ReadyService;
import com.hourlyrecruit.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicContentController {

    @Autowired
    private FAQService faqService;

    @Autowired
    private ReadyService ctaSectionService;

    // ================= FAQ =================

    @GetMapping("/faq")
    public ResponseEntity<List<FAQ>> getAllFAQ() {
    	return ResponseEntity.ok(faqService.getAllFAQs());
    }

    // ================= CTA =================

    @GetMapping("/cta")
    public ResponseEntity<List<ReadySection>> getAllCTA() { 
    	return ResponseEntity.ok(ctaSectionService.getAll());
    } 
}