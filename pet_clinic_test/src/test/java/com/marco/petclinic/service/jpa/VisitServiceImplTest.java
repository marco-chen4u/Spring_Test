package com.marco.petclinic.service.jpa;

import com.marco.petclinic.dao.VisitRepository;
import com.marco.petclinic.model.Speciality;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;
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

    @Test
    void testThrowExceptionWhenDelete() {
        willThrow(new RuntimeException("delete-exception")).given(visitRepository).delete(any());

        assertThrows(RuntimeException.class, ()->visitRepository.delete(new Visit()));

        then(visitRepository).should().delete(any());
    }

    @Test
    void testFindByIDThrows() {
        given(visitRepository.findById(1l)).willThrow(new RuntimeException("findById exception"));

        assertThrows(RuntimeException.class, ()->service.findById(1l));

        then(visitRepository).should().findById(1l);
    }
}
