package com.marco.petclinic.utils;

public interface BindingResult {

    void rejectValue(String lastName, String notFound, String not_found);

    boolean hasErrors();
}
