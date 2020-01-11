package com.marco.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{
    // fields
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    // constructor
    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    // methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew) {

        for (Pet pet : pets) {

            // check corner case and input conditions
            if (ignoreNew && pet.isNew()) {
                continue;
            }

            String currentPetName = pet.getName();
            if (currentPetName.equalsIgnoreCase(name)){
                return pet;
            }

        }

        return null;
    }
}
