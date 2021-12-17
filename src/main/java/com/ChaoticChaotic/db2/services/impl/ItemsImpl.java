package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemsImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ShippingsRepository shippingsRepository;


    public String deleteItem(Long id) {
        if(!(shippingsRepository.findById(id).isPresent())) {
            itemsRepository.deleteById(id);
        }
        return "Deleted";
    }


    public List<Items> showItems() {
        List<Items> allItems = new ArrayList<>();
        itemsRepository.findAll().forEach(town -> allItems.add(town));
        return allItems;
    }


    public String addItem(Items item) {
        itemsRepository.save(item);
        return "Saved";
    }
}
