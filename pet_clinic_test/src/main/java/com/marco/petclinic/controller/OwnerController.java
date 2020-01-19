package com.marco.petclinic.controller;

import com.marco.petclinic.model.Owner;
import com.marco.petclinic.service.OwnerService;
import com.marco.petclinic.utils.BindingResult;
import com.marco.petclinic.utils.Model;
import com.marco.petclinic.utils.ModelAndView;
import com.marco.petclinic.utils.WebDataBinder;

import java.util.List;

public class OwnerController {
    private static final String VIEWS_OWNER_CRAEATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    // constructor
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner(null, null, null));
        return "owners/findOwners";
    }

    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if (results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            model.addAttribute("selections", results);
            return "owners/ownerList";
        }
    }

    public ModelAndView showOwner(Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner(null, null, null));
        return VIEWS_OWNER_CRAEATE_OR_UPDATE_FORM;
    }

    public String processCreationForm(Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CRAEATE_OR_UPDATE_FORM;
        }
        else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    public String initUpdateOwnerForm(Long ownId, Model model) {
        model.addAttribute(ownerService.findById(ownId));
        return VIEWS_OWNER_CRAEATE_OR_UPDATE_FORM;
    }

    public String processUpdateOwnerForm(Owner owner, BindingResult result, Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CRAEATE_OR_UPDATE_FORM;
        }
        else {
            owner.setId(ownerId);
            Owner saveOwner = ownerService.save(owner);
            return "redirect:/owners/" + saveOwner.getId();
        }
    }
}
