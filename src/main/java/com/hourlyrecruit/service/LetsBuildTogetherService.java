package com.hourlyrecruit.service;

import com.hourlyrecruit.model.LetsBuildTogether;
import com.hourlyrecruit.repository.LetsBuildTogetherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetsBuildTogetherService {

    @Autowired
    private LetsBuildTogetherRepository repository;

    // CREATE
    public LetsBuildTogether create(LetsBuildTogether data) {
        return repository.save(data);
    }

    // GET ALL
    public List<LetsBuildTogether> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public LetsBuildTogether getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    public LetsBuildTogether update(Long id, LetsBuildTogether data) {

        LetsBuildTogether existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setCardTitle(data.getCardTitle());
            existing.setHeading(data.getHeading());
            existing.setSubHeading(data.getSubHeading());
            existing.setImage1Url(data.getImage1Url());

            existing.setPointOneTitle(data.getPointOneTitle());
            existing.setPointOneDescription(data.getPointOneDescription());
            existing.setImage2Url(data.getImage2Url());

            existing.setPointTwoTitle(data.getPointTwoTitle());
            existing.setPointTwoDescription(data.getPointTwoDescription());
            existing.setImage3Url(data.getImage3Url());

            existing.setPointThreeTitle(data.getPointThreeTitle());
            existing.setPointThreeDescription(data.getPointThreeDescription()); 

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}