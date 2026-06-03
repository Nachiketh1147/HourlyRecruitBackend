package com.hourlyrecruit.service;

import com.hourlyrecruit.model.ContactInfo;
import com.hourlyrecruit.repository.ContactInfoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository repository;

    public ContactInfo create(ContactInfo info) {
        return repository.save(info);
    }

    public List<ContactInfo> getAll() {
        return repository.findAll();
    }

    public ContactInfo getById(Long id) {
    	return repository.findById(id).orElseThrow(() ->new RuntimeException("Contact Info Not Found"));
    }

    public ContactInfo update(Long id, ContactInfo updated) {

    	 ContactInfo existing =
                repository.findById(id).orElse(null);

         if (existing != null) {
        existing.setCardTitle(updated.getCardTitle()); 
        existing.setHeading(updated.getHeading());
        existing.setSubHeading(updated.getSubHeading());
        existing.setLocation(updated.getLocation());
        existing.setLocImgUrl(updated.getLocImgUrl());
        existing.setEmail(updated.getEmail());
        existing.setEmailImgUrl(updated.getEmailImgUrl());
        existing.setPhone(updated.getPhone());
        existing.setPhImgUrl(updated.getPhImgUrl());
        existing.setWebsite(updated.getWebsite());
        existing.setWebImgUrl(updated.getWebImgUrl()); 
         }

        return repository.save(existing);
    
    }

    public String delete(Long id) {
        repository.deleteById(id);
        return "Contact Info Deleted Successfully";
    }
    
}