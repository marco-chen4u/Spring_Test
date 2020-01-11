package com.marco.petclinic.controller;

import com.marco.petclinic.model.Vet;
import com.marco.petclinic.service.SpecialityService;
import com.marco.petclinic.service.VetService;
import com.marco.petclinic.service.map.SpecialityMapServiceImpl;
import com.marco.petclinic.service.map.VetMapServiceImpl;
import com.marco.petclinic.utils.Model;
import com.marco.petclinic.utils.impl.ModelImpl;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest {

    // fields
    private final Long DEFAULT_ID = RandomUtils.nextLong();
    private VetService vetService;
    private SpecialityService specialityService;
    private VetController vetController;

    private List<Vet> generateVets() {
        Vet[] vets = new Vet[2];

        vets[0] = new Vet(DEFAULT_ID, "Jenny", "Buck", null);
        vets[1] = new Vet(DEFAULT_ID + 1, "Jimmy", "Butler", null);

        return Arrays.asList(vets);
    }

    @BeforeEach
    void setUp() {
        specialityService = new SpecialityMapServiceImpl();
        vetService = new VetMapServiceImpl(specialityService);
        vetController = new VetController(vetService);

        generateVets().forEach(vet -> vetService.save(vet));
    }

    @AfterEach
    void tearDown() {
        specialityService = null;
        vetService = null;
        vetController = null;
    }

    @Test
    void listVets() {
        Model model = new ModelImpl();

        String view = vetController.listVets(model);
        String keyStr = "vets";

        assertThat("vets/index").isEqualTo(view);

        Set set = (Set) ((ModelImpl) model).getAttributeMap().get(keyStr);
        assertThat(set.size()).isEqualTo(2);
    }
}
