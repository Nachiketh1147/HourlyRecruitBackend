package com.hourlyrecruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hourlyrecruit.model.Footer;

@Repository
public interface FooterRepository extends JpaRepository<Footer, Long> {
}