package com.hourlyrecruit.repository;

import com.hourlyrecruit.model.TrustedCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrustedCompanyRepository
        extends JpaRepository<TrustedCompany, Long> {
}