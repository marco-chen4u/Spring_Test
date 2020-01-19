package com.marco.petclinic.controller;

import com.marco.petclinic.model.Owner;
import com.marco.petclinic.service.OwnerService;
import com.marco.petclinic.utils.BindingResult;
import com.marco.petclinic.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    // fields
    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS = "redirect:/owners/";

    @Mock
    OwnerService service;

    @InjectMocks
    OwnerController controller;

    @Mock
    BindingResult bindingResult;

    @Test
    void processCreationFormHasErrors() {
        // given
        long id = Utils.getRandomID();
        Owner owner = new Owner(id, "Jackie", "Chan");
        given(bindingResult.hasErrors()).willReturn(true);

        // when
        String viewName = controller.processCreationForm(owner, bindingResult);

        // then
        assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
    }

    @Test
    void processCreationFormNoErrors() {
        // given
        long id = Utils.getRandomID();
        Owner owner = new Owner(id, "Jackie", "Chan");
        given(bindingResult.hasErrors()).willReturn(false);
        given(service.save(any())).willReturn(owner);

        // when
        String viewName = controller.processCreationForm(owner, bindingResult);

        // then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS + id);
    }
}
