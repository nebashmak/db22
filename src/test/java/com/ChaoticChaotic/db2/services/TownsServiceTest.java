package com.ChaoticChaotic.db2.services;

import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import com.ChaoticChaotic.db2.services.impl.TownsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TownsServiceTest {

    @Mock
    private TownsRepository townsRepository;
    @InjectMocks
    private TownsImpl underTest;


    @Test
    void canAddTown() {
        Towns test = new Towns(1L, "Voronezh"
                ,1222L
        );
        underTest.addTown(test);
        ArgumentCaptor<Towns> townArgumentCaptor =
                ArgumentCaptor.forClass(Towns.class);
        verify(townsRepository)
                .save(townArgumentCaptor.capture());
        Towns capturedShipping = townArgumentCaptor.getValue();
        assertThat(capturedShipping).isEqualTo(test);
    }

    @Test
    void whenTryDeleteTownThenThrowException(){
        Long deletionId = 1L;
        given(townsRepository.existsById(any()))
                .willReturn(false);
        assertThatThrownBy(()-> underTest.deleteTown(deletionId))
                .isInstanceOf(IdNotFoundException.class)
                .hasMessage("Line with id " + deletionId + " does not exists");
        verify(townsRepository,never()).deleteById(any());
    }

    @Test
    void canDeleteTown() {
        Long deletionId = 1L;
        given(townsRepository.existsById(any()))
                .willReturn(true);
        underTest.deleteTown(deletionId);
        verify(townsRepository).deleteById(any());
    }

    @Test
    void canShowTowns() {
        underTest.showTowns();
        verify(townsRepository).findAll();
    }
}