package com.ChaoticChaotic.db2.services;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.impl.ItemsImpl;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
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
class ItemsServiceTest {

    @Mock
    private ItemsRepository itemsRepository;
    @Mock
    private ShippingsRepository shippingsRepository;
    private ItemsService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ItemsImpl(itemsRepository,shippingsRepository);
    }


    @Test
    @Disabled
    void deleteItem() {
    }

    @Test
    void canShowItems() {
        underTest.showItems();
        verify(itemsRepository).findAll();
    }

    @Test
    void canAddItem() {
        Items test = new Items("Oranges"
                ,1222L
        );
        underTest.addItem(test);
        ArgumentCaptor<Items> itemArgumentCaptor =
                ArgumentCaptor.forClass(Items.class);
        verify(itemsRepository)
                .save(itemArgumentCaptor.capture());
        Items capturedShipping = itemArgumentCaptor.getValue();
        assertThat(capturedShipping).isEqualTo(test);
    }
}