package com.hourlyrecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourlyrecruit.model.FAQ;
import com.hourlyrecruit.repository.FAQRepository;

@Service
public class FAQService {

    @Autowired
    private FAQRepository faqRepository;

    // CREATE
    public FAQ createFAQ(FAQ faq) {
        return faqRepository.save(faq);
    }

    // GET ALL
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    // GET BY ID
    public FAQ getFAQById(Long id) {
        return faqRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("FAQ not found"));
    }

    // UPDATE
    public FAQ updateFAQ(Long id, FAQ updatedFAQ) {

        FAQ faq = getFAQById(id);
        faq.setCardTitle(updatedFAQ.getCardTitle());
        faq.setHeading(updatedFAQ.getHeading());
        faq.setSubHeading(updatedFAQ.getSubHeading()); 
        faq.setQuestion(updatedFAQ.getQuestion());
        faq.setAnswer(updatedFAQ.getAnswer());

        return faqRepository.save(faq);
    }

    // DELETE
    public String deleteFAQ(Long id) {

        FAQ faq = getFAQById(id);

        faqRepository.delete(faq);

        return "FAQ deleted successfully";
    }
}