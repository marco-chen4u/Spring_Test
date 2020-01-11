package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.OwnerRepository;
import com.marco.petclinic.dao.PetRepository;
import com.marco.petclinic.dao.PetTypeRepository;
import com.marco.petclinic.model.Owner;
import com.marco.petclinic.service.OwnerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OwnerServiceimpl implements OwnerService {

    // fields
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    // constructor
    public OwnerServiceimpl(OwnerRepository ownerRepository,
                            PetRepository petRepository,
                            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> result = new HashSet<Owner>();

        ownerRepository.findAll()
                .forEach(result::add);

        return result;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
