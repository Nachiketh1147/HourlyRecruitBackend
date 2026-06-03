package com.hourlyrecruit.service;

import com.hourlyrecruit.model.ContactMessage;
import com.hourlyrecruit.repository.ContactMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public ContactMessage create(ContactMessage message) {
        return repository.save(message);
    }

    public List<ContactMessage> getAll() {
        return repository.findAll();
    }

    public ContactMessage getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Message Not Found"));
    }

    public String delete(Long id) {

        repository.deleteById(id);

        return "Message Deleted Successfully";
    }
}