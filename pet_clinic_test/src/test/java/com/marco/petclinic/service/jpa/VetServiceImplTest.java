package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetServiceImplTest {

    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetServiceImpl service;

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(vetRepository).deleteById(1l);
    }
}
