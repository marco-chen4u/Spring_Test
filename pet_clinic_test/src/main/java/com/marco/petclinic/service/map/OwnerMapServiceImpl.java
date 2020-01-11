package com.marco.petclinic.service.map;

import com.marco.petclinic.model.Owner;
import com.marco.petclinic.model.Pet;
import com.marco.petclinic.model.PetType;
import com.marco.petclinic.service.OwnerService;
import com.marco.petclinic.service.PetService;
import com.marco.petclinic.service.PetTypeService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    // fields
    private final PetTypeService petTypeService;
    private final PetService petService;

    // constructor
    public OwnerMapServiceImpl(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().contains((CharSequence) lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        // check corner case
        if (object == null) {
            return object;
        }

        Set<Pet> pets = object.getPets();

        if (pets != null && !pets.isEmpty()) {
            for (Pet pet : pets) {

                // check pet type
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        PetType petType = petTypeService.save(pet.getPetType());
                        pet.setPetType(petType);
                    }
                }
                else {
                    throw new RuntimeException("Pet Type is required");
                }

                // check pet id
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            }
        }

        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
