package com.hourlyrecruit.controller.howitworks;

import com.hourlyrecruit.model.ReadySection;
import com.hourlyrecruit.model.FAQ;
import com.hourlyrecruit.service.ReadyService;
import com.hourlyrecruit.service.FAQService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminContentController {

    @Autowired
    private FAQService faqService;

    @Autowired
    private ReadyService ctaSectionService;

    // ================= FAQ =================

    @PostMapping("/faq")
    public ResponseEntity<FAQ> createFAQ(@RequestBody FAQ faq) {
    	return ResponseEntity.ok(faqService.createFAQ(faq));
    }

    @PutMapping("/faq/{id}")
    public ResponseEntity<FAQ> updateFAQ(@PathVariable Long id,@RequestBody FAQ faq) {
    	return ResponseEntity.ok(faqService.updateFAQ(id, faq));
    }

    @DeleteMapping("/faq/{id}")
    public ResponseEntity<String> deleteFAQ(@PathVariable Long id){
    	faqService.deleteFAQ(id);
    	return ResponseEntity.ok("FAQ deleted");
    }


    // ================= CTA SECTION =================

    @PostMapping("/cta")
    public ResponseEntity<ReadySection> createCTA(@RequestBody ReadySection cta) {
    	return ResponseEntity.ok(ctaSectionService.create(cta));
    }

    @PutMapping("/cta/{id}")
    public ResponseEntity<ReadySection> updateCTA(@PathVariable Long id,@RequestBody ReadySection cta) {
    	return ResponseEntity.ok(ctaSectionService.update(id, cta) );
    }

    @DeleteMapping("/cta/{id}")
    public ResponseEntity<String> deleteCTA(@PathVariable Long id) {
    	ctaSectionService.delete(id);
        return ResponseEntity.ok("CTA deleted");
    }
}