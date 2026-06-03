package com.hourlyrecruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hourlyrecruit.dto.FooterResponseDTO;
import com.hourlyrecruit.model.Footer;
import com.hourlyrecruit.model.FooterQuickLink;
import com.hourlyrecruit.model.FooterServiceItem;
import com.hourlyrecruit.repository.FooterQuickLinkRepository;
import com.hourlyrecruit.repository.FooterRepository;
import com.hourlyrecruit.repository.FooterServiceRepository;
 
@Service
public class FooterService {

    @Autowired
    private FooterRepository footerRepository;

    @Autowired
    private FooterQuickLinkRepository quickLinkRepository;

    @Autowired
    private FooterServiceRepository footerServiceRepository;

    // FOOTER

    public Footer save(Footer footer) {
        return footerRepository.save(footer);
    }

    public Footer update(Long id, Footer updated) {

        Footer footer = footerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Footer not found"));

        footer.setCompanyLogo(updated.getCompanyLogo());
        footer.setCompanyName(updated.getCompanyName());
        footer.setCompanyDescription(updated.getCompanyDescription());

        footer.setLinkedinUrl(updated.getLinkedinUrl());
        footer.setTwitterUrl(updated.getTwitterUrl());
        footer.setYoutubeUrl(updated.getYoutubeUrl());

        footer.setAddress(updated.getAddress());
        footer.setEmail(updated.getEmail());
        footer.setPhone(updated.getPhone());
        footer.setWebsite(updated.getWebsite());

        footer.setCopyrightText(updated.getCopyrightText());
        footer.setPrivacyPolicyUrl(updated.getPrivacyPolicyUrl());
        footer.setTermsOfServiceUrl(updated.getTermsOfServiceUrl());

        return footerRepository.save(footer);
    }

    public void deleteFooter(Long id) {
        footerRepository.deleteById(id);
    }

    // QUICK LINKS

    public FooterQuickLink saveQuickLink(FooterQuickLink quickLink) {
        return quickLinkRepository.save(quickLink);
    }

    public void deleteQuickLink(Long id) {
        quickLinkRepository.deleteById(id);
    }

    // SERVICES

    public FooterServiceItem saveFooterService(FooterServiceItem service) {
        return footerServiceRepository.save(service);  
    }

    public void deleteFooterService(Long id) {
        footerServiceRepository.deleteById(id);
    }

    // PUBLIC RESPONSE

    public FooterResponseDTO getFooterData() {

        Footer footer = footerRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Footer not found"));

        FooterResponseDTO dto = new FooterResponseDTO();

        dto.setFooter(footer);

        dto.setQuickLinks(
                quickLinkRepository.findByFooter(footer));

        dto.setServices(
                footerServiceRepository.findByFooter(footer));

        return dto;
    }
}