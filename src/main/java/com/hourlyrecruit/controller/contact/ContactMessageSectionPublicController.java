package com.hourlyrecruit.controller.contact; 

import com.hourlyrecruit.model.ContactMessageSection;
import com.hourlyrecruit.service.ContactMessageSectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-message-section")
public class ContactMessageSectionPublicController {

    @Autowired
    private ContactMessageSectionService service;

    @GetMapping
    public List<ContactMessageSection> getAll() {
        return service.getAll();
    }
}