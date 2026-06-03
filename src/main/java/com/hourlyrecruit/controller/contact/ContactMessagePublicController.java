package com.hourlyrecruit.controller.contact; 

import com.hourlyrecruit.model.ContactMessage;
import com.hourlyrecruit.service.ContactMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/contact-message")
public class ContactMessagePublicController {

    @Autowired
    private ContactMessageService service;

    @PostMapping
    public ResponseEntity<ContactMessage> create(
            @RequestBody ContactMessage message
    ) {

        return ResponseEntity.ok(
                service.create(message)
        );
    }
}