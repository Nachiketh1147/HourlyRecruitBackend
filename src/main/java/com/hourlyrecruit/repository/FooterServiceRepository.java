package com.hourlyrecruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlyrecruit.model.Footer;
import com.hourlyrecruit.model.FooterServiceItem;

public interface FooterServiceRepository
        extends JpaRepository<FooterServiceItem, Long> {

    List<FooterServiceItem> findByFooter(Footer footer);
}