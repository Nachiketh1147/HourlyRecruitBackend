package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}