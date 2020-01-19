package com.marco.petclinic.controller;

import com.marco.petclinic.model.Owner;
import com.marco.petclinic.service.OwnerService;
import com.marco.petclinic.utils.BindingResult;
import com.marco.petclinic.utils.Model;
import com.marco.petclinic.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    // fields
    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS = "redirect:/owners/";
    private static long id;

    @Mock(lenient = true)
    OwnerService service;

    @InjectMocks
    OwnerController controller;

    @Mock
    BindingResult bindingResult;

    @Mock
    Model model;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeEach
    void setUp() {
        given(service.findAllByLastNameLike(stringArgumentCaptor.capture())).willAnswer(
                invocationOnMock -> {
                    List<Owner> ownerList = new ArrayList<>();
                    String name = invocationOnMock.getArgument(0);
                    id = Utils.getRandomID();
                    Owner owner = new Owner(id, "Marco", "Chen");
                    Owner owner2 = new Owner(id + 1, "Allen", "Jackson");

                    switch (name) {
                        case "%Chen%":
                            ownerList.add(owner);
                            return ownerList;
                        case "%DontFindMe%" :
                            return ownerList;
                        case "%FindMe%" :
                            ownerList.add(owner);
                            ownerList.add(owner2);
                            return ownerList;
                        default:
                            throw  new RuntimeException("Invalid Argument");
                    }
                });
    }

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

    @Test
    void processFindFormWildCardTest() {
        // given
        //long id = Utils.getRandomID();
        Owner owner = new Owner(id, "Marco", "Chen");
        //List<Owner> ownerList = new ArrayList<>();
        //given(service.findAllByLastNameLike(stringArgumentCaptor.capture())).willReturn(ownerList);

        // when
        String viewName = controller.processFindForm(owner, bindingResult, null);

        // then
        String expectValue = "%Chen%";
        assertThat(expectValue).isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("redirect:/owners/" + id).isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildCardNotFound() {
        // given
        Owner owner = new Owner(id, "Marco", "DontFindMe");

        // when
        String viewName = controller.processFindForm(owner, bindingResult, null);

        // then
        String expectValue = "%DontFindMe%";
        assertThat(expectValue).isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildCardFindMe() {
        // given
        Owner owner = new Owner(id, "Marco", "FindMe");
        InOrder inOrder = Mockito.inOrder(service, model);// make sure the dependencies in order properly

        // when
        String viewName = controller.processFindForm(owner, bindingResult, model);

        // then
        String expectValue = "%FindMe%";
        assertThat(expectValue).isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/ownerList").isEqualToIgnoringCase(viewName);

        //      inorder asserts
        inOrder.verify(service).findAllByLastNameLike(any());
        inOrder.verify(model).addAttribute(anyString(), anyList());
    }
}
