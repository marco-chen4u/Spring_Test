package com.marco.petclinic.service.map;

import com.marco.petclinic.model.Visit;
import com.marco.petclinic.service.VisitService;

import java.util.Set;

public class VisitMapServiceImpl extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        // check corner case
        if (visit.getPet() == null ||
            visit.getPet().getOwner() == null ||
            visit.getPet().getId() == null ||
            visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
