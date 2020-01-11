package com.marco.petclinic.service.map;

import com.marco.petclinic.model.Speciality;
import com.marco.petclinic.model.Vet;
import com.marco.petclinic.service.SpecialityService;
import com.marco.petclinic.service.VetService;

import java.util.Set;

public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

    // fields
    private final SpecialityService specialityService;

    // constructor
    public VetMapServiceImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        // check speciality
        Set<Speciality> specialities = object.getSpecialities();

        if (specialities != null && !specialities.isEmpty()) {
            for (Speciality speciality : specialities) {
                if (speciality.getId() == null) {
                    Speciality saved = specialityService.save(speciality);
                    speciality.setId(saved.getId());
                }
            }
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
