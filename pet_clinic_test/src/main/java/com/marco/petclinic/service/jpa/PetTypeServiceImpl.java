package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.PetTypeRepository;
import com.marco.petclinic.model.Pet;
import com.marco.petclinic.model.PetType;
import com.marco.petclinic.service.PetService;
import com.marco.petclinic.service.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeServiceImpl implements PetTypeService {

    // field
    private final PetTypeRepository petTypeRepository;

    // constructor
    public PetTypeServiceImpl(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> result = new HashSet<>();

        petTypeRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
