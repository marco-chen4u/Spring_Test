package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.VisitRepository;
import com.marco.petclinic.model.Visit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitServiceImplTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitServiceImpl service;

    @Test
    void findAll() {
        // given
        Visit visit = new Visit();
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);
        given(visitRepository.findAll()).willReturn(visitSet);

        // when
        Set<Visit> result = service.findAll();

        // then
        then(visitRepository).should().findAll();
        assertThat(result).hasSize(1);
    }

    @Test
    void findById() {
        // given
        Visit visit = new Visit();
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));

        // when
        Visit result = service.findById(1l);

        // then
        then(visitRepository).should().findById(anyLong());
        assertThat(result).isNotNull();
    }

    @Test
    void save() {
        // given
        Visit visit = new Visit();
        given(visitRepository.save(any(Visit.class))).willReturn(visit);

        // when
        Visit savedVisit = service.save(new Visit());

        // then
        then(visitRepository).should().save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        // given
        Visit visit = new Visit();

        // when
        service.delete(visit);

        // then
        then(visitRepository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        // when
        service.deleteById(1l);

        // then
        then(visitRepository).should().deleteById(anyLong());
    }
}
