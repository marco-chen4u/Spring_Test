package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.VetRepository;
import com.marco.petclinic.model.Vet;
import com.marco.petclinic.service.VetService;

import java.util.HashSet;
import java.util.Set;

public class VetServiceImpl implements VetService {

    // field
    private final VetRepository vetRepository;

    // constructor
    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> result = new HashSet();

        vetRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
