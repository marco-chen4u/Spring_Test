package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.PetRepository;
import com.marco.petclinic.model.Pet;
import com.marco.petclinic.service.PetService;

import java.util.HashSet;
import java.util.Set;

public class PetServiceImpl implements PetService {

    // field
    private final PetRepository petRepository;

    // constructor
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> result = new HashSet<>();

        petRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
