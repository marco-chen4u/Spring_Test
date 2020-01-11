package com.marco.petclinic.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    // field
    private Set<Speciality> specialities = new HashSet<>();

    // constructor
    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    // methods
    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
