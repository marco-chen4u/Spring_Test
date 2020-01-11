package com.marco.petclinic.service.map;

import com.marco.petclinic.model.Pet;
import com.marco.petclinic.model.PetType;
import com.marco.petclinic.service.PetTypeService;

import java.util.Set;

public class PetTypeMapServiceImpl extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
