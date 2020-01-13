package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.SpecialityRepository;
import com.marco.petclinic.model.Speciality;
import com.marco.petclinic.utils.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialityServiceImplTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialityServiceImpl service;

    @Test
    void testFindById() {
        Speciality speciality = new Speciality();

        when(specialityRepository.findById(1l)).thenReturn(Optional.of(speciality));// return values from Mockito Mock(s)

        Speciality foundSpeciality = service.findById(1l);

        assertThat(foundSpeciality).isNotNull();

        verify(specialityRepository).findById(1l);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1l);

        verify(specialityRepository).deleteById(1l);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }

    @Test
    void testDeleteByObject() {
        Speciality speciality = new Speciality();

        service.delete(speciality);

        verify(specialityRepository).delete(any(Speciality.class));// argument matcher
    }
}
