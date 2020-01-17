package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.SpecialityRepository;
import com.marco.petclinic.model.Speciality;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialityServiceImplTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialityServiceImpl service;

    @Test
    void findByIDest() {
        // given
        Speciality speciality = new Speciality();
        given(specialityRepository.findById(1l)).willReturn(Optional.of(speciality));

        // when
        Speciality foundSpeciality = service.findById(1l);

        // then
        assertThat(foundSpeciality).isNotNull();
        then(specialityRepository).should().findById(anyLong());
        then(specialityRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void testDeleteById() {
        // given - none

        // when
        service.deleteById(1l);
        service.deleteById(1l);

        // then
        then(specialityRepository).should(times(2)).deleteById(1l);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }

    @Test
    void testDeleteByObject() {
        // given
        Speciality speciality = new Speciality();

        // when
        service.delete(speciality);

        // then
        then(specialityRepository).should().delete(any(Speciality.class));// argument matcher
    }
}
