package com.ChaoticChaotic.db2.services;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import com.ChaoticChaotic.db2.services.impl.TownsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class TownsServiceTest {

    @Mock
    private TownsRepository townsRepository;
    @Mock
    private ShippingsRepository shippingsRepository;
    private TownsService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TownsImpl(townsRepository,shippingsRepository);
    }

    @Test
    void canAddTown() {
        Towns test = new Towns("Voronezh"
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
    @Disabled
    void deleteTown() {
    }

    @Test
    void canShowTowns() {
        underTest.showTowns();
        verify(townsRepository).findAll();
    }
}