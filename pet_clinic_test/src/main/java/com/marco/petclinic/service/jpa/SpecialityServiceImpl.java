package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.SpecialityRepository;
import com.marco.petclinic.model.Speciality;
import com.marco.petclinic.service.SpecialityService;

import java.util.HashSet;
import java.util.Set;

public class SpecialityServiceImpl implements SpecialityService {

    // field
    private final SpecialityRepository specialityRepository;

    // constructor
    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> result = new HashSet<>();

        specialityRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
