package com.ChaoticChaotic.db2.services;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.exception.BadRequestException;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.impl.ItemsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ItemsServiceTest {

    @Mock
    private ItemsRepository itemsRepository;
    @Mock
    private ShippingsRepository shippingsRepository;
    @InjectMocks
    private ItemsImpl underTest;

    @Test
    void canAddItem() {
        Items test = new Items(1L,"Oranges"
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

    @Test
    void whenTryDeleteItemThenThrowExceptionLineNotExists(){
        Long deletionId = 1L;
        given(itemsRepository.existsById(any()))
                .willReturn(false);
        assertThatThrownBy(()-> underTest.deleteItem(deletionId))
                .isInstanceOf(IdNotFoundException.class)
                .hasMessage("Line with id " + deletionId + " does not exists");
        verify(itemsRepository,never()).deleteById(any());
    }

    @Test
    void whenTryDeleteItemThenThrowExceptionPrimaryKeyUsedAsForeignKey(){
        Long deletionId = 1L;
        given(itemsRepository.existsById(any()))
                .willReturn(true);
        given(shippingsRepository.existsById(any()))
                .willReturn(true);
        assertThatThrownBy(()-> underTest.deleteItem(deletionId))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Line with id " + deletionId + " is busy");
        verify(itemsRepository,never()).deleteById(any());
    }

    @Test
    void canDeleteItem() {
        Long deletionId = 1L;
        given(itemsRepository.existsById(any()))
                .willReturn(true);
        given(shippingsRepository.existsById(any()))
                .willReturn(false);
        underTest.deleteItem(deletionId);
        verify(itemsRepository).deleteById(any());
    }

    @Test
    void canShowItems() {
        underTest.showItems();
        verify(itemsRepository).findAll();
    }

}