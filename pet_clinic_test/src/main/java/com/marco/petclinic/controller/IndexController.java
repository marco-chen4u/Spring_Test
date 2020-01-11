package com.marco.petclinic.controller;

import com.marco.petclinic.utils.exception.ValueNotFoundException;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oupsHandler() {
        return "notImplemented";
    }

    public String getException() {
        throw new ValueNotFoundException();
    }
}
