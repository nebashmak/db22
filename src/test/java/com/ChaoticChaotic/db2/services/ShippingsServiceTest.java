package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.exception.BadRequestException;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ShippingsServiceTest {

    @Mock
    private ShippingsRepository shippingsRepository;
    private ShippingsService underTest;


    @BeforeEach
    void setUp() {
        underTest = new ShippingsImpl(shippingsRepository);
    }

    @Test
    void canAddShipping() {
        Shippings test = new Shippings(LocalDate.of(2021,1,24)
                ,LocalDate.of(2021,1,26)
                ,new Towns("Voronezh",1222L),
                 new Items("Oranges",1222L)
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
    void throwExceptionWhenEndDateIsBeforeStart() {
        Shippings test = new Shippings(LocalDate.of(2021,1,26)
                ,LocalDate.of(2021,1,24)
                ,new Towns("Voronezh",1222L),
                new Items("Oranges",1222L)
        );
        assertThatThrownBy(()-> underTest.addShipping(test))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Incorrect shipping dates!");
    }

    @Test
    @Disabled
    void canDeleteShipping() {
        Shippings test = new Shippings(LocalDate.of(2021,1,24)
                ,LocalDate.of(2021,1,26)
                ,new Towns("Voronezh",1222L),
                new Items("Oranges",1222L)
        );
        underTest.deleteShipping(test.getShippingId());
        verify(shippingsRepository)
                .deleteById(test.getShippingId());
    }

    @Test
    void canShowShipping() {
        underTest.showShipping();
        verify(shippingsRepository).findAll();
    }
}