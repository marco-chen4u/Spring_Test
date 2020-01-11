package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.VisitRepository;
import com.marco.petclinic.model.Visit;
import com.marco.petclinic.service.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitServiceImpl implements VisitService {

    // field
    private final VisitRepository visitRepository;

    // constructor
    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> result = new HashSet<>();

        visitRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
