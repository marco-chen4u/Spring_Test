package com.marco.petclinic.utils;

import com.marco.petclinic.model.PetType;

import java.text.ParseException;
import java.util.Locale;

public interface Formatter {
    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
