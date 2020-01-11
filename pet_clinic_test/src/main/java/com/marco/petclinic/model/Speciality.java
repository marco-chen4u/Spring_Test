package com.marco.petclinic.model;

public class Speciality extends BaseEntity {
    // fields
    private String description;

    // constructors
    public Speciality() {

    }

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }

    // methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
