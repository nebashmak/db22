package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ShippingsRepository shippingsRepository;

    @DeleteMapping("/items")
    public void deleteItem(Long id) {
        if(!(shippingsRepository.findById(id).isPresent())) {
            itemsRepository.deleteById(id);
        }
    }

    @GetMapping("/items")
    public void showItems() {
        List<Items> allItems = new ArrayList<>();
        itemsRepository.findAll().forEach(item -> allItems.add(item));
        for(Items item: allItems)
        System.out.println(item.toString());
    }

    @PostMapping("/items")
    public void addItem(Items item) {
        itemsRepository.save(item);
    }
}
