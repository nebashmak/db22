package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.exception.BadRequestException;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ShippingsServiceTest {

    @Mock
    private ShippingsRepository shippingsRepository;
    @InjectMocks
    private ShippingsImpl underTest;


    @Test
    void canAddShipping() {
        Shippings test = new Shippings(1L, LocalDate.of(2021,1,24)
                ,LocalDate.of(2021,1,26)
                ,new Towns(1L, "Voronezh",1222L),
                 new Items(1L,"Oranges",1222L)
        );
        underTest.addShipping(test);
        ArgumentCaptor<Shippings> shippingArgumentCaptor =
                ArgumentCaptor.forClass(Shippings.class);
        verify(shippingsRepository)
                .save(shippingArgumentCaptor.capture());
        Shippings capturedShipping = shippingArgumentCaptor.getValue();
        assertThat(capturedShipping).isEqualTo(test);
    }

    @Test
    void whenEndDateIsBeforeStartThrowException() {
        Shippings test = new Shippings(1L, LocalDate.of(2021,1,26)
                ,LocalDate.of(2021,1,24)
                ,new Towns(1L, "Voronezh",1222L),
                new Items(1L,"Oranges",1222L)
        );
        assertThatThrownBy(()-> underTest.addShipping(test))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Incorrect shipping dates!");
        verify(shippingsRepository,never()).save(any());
    }

    @Test
    void whenTryDeleteItemThenThrowExceptionLineNotExists(){
        Long deletionId = 1L;
        given(shippingsRepository.existsById(any()))
                .willReturn(false);
        assertThatThrownBy(()-> underTest.deleteShipping(deletionId))
                .isInstanceOf(IdNotFoundException.class)
                .hasMessage("Line with id " + deletionId + " does not exists");
        verify(shippingsRepository,never()).deleteById(any());
    }

    @Test
    void canDeleteShipping() {
        Long deletionId = 1L;
        given(shippingsRepository.existsById(any()))
                .willReturn(true);
        underTest.deleteShipping(deletionId);
        verify(shippingsRepository).deleteById(any());
    }

    @Test
    void canShowShipping() {
        underTest.showShipping();
        verify(shippingsRepository).findAll();
    }
}