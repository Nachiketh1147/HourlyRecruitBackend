package com.hourlyrecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.Footer;
import com.hourlyrecruit.model.FooterQuickLink;

public interface FooterQuickLinkRepository
        extends JpaRepository<FooterQuickLink, Long> {

    List<FooterQuickLink> findByFooter(Footer footer);
}