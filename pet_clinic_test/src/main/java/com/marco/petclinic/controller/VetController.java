package com.marco.petclinic.controller;

import com.marco.petclinic.service.VetService;
import com.marco.petclinic.utils.Model;

public class VetController {
    // field
    private final VetService vetService;

    // constructor
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
