package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.exception.BadRequestException;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemsImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ShippingsRepository shippingsRepository;

    public void addItem(Items item) {
        itemsRepository.save(item);
    }

    public void deleteItem(Long id) {
        if(!itemsRepository.existsById(id)) {
            throw new IdNotFoundException(
                    "Line with id " + id + " does not exists");
        }
        if(shippingsRepository.existsById(id)) {
            throw new BadRequestException(
                    "Line with id " + id + " is busy");
        }
        itemsRepository.deleteById(id);
    }

    public List<Items> showItems() {
        return itemsRepository.findAll();
    }

    public ItemsImpl(ItemsRepository itemsRepository, ShippingsRepository shippingsRepository) {
        this.itemsRepository = itemsRepository;
        this.shippingsRepository = shippingsRepository;
    }
}
