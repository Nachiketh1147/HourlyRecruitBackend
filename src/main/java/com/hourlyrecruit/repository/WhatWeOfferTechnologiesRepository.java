package com.hourlyrecruit.repository;


import com.hourlyrecruit.model.WhatWeOfferTechnologies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatWeOfferTechnologiesRepository
        extends JpaRepository<WhatWeOfferTechnologies, Long> {
	 List<WhatWeOfferTechnologies> findAllByOrderByDisplayOrderAsc(); 
} 