package com.hourlyrecruit.service;

import com.hourlyrecruit.model.ContactMessageSection;
import com.hourlyrecruit.repository.ContactMessageSectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageSectionService {

    @Autowired
    private ContactMessageSectionRepository repository;

    // CREATE
    public ContactMessageSection create(ContactMessageSection section) {
    	return repository.save(section);
    }

    // GET ALL
    public List<ContactMessageSection> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public ContactMessageSection getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // GET BY SECTION NAME
    public ContactMessageSection getBySectionName(
            String sectionName) {

        return repository.findBySectionName(sectionName);
    }

    // UPDATE
    public ContactMessageSection update(Long id,ContactMessageSection updated) {

        ContactMessageSection existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setSectionName(updated.getSectionName());
            existing.setCardTitle(updated.getCardTitle());
            existing.setActive(updated.isActive());

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public String delete(Long id) {
        repository.deleteById(id); 
        return "Section Deleted Successfully";
    }
}