package com.ChaoticChaotic.db2.controllers;


import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.services.ItemsService;
import com.ChaoticChaotic.db2.services.impl.ItemsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    private ItemsService itemsService;


    @GetMapping("/items")
    private List<Items> showItems(){
      return itemsService.showItems();
    }

    @DeleteMapping("/items/{id}")
    private void deleteItem(@PathVariable("id") Long id){
        itemsService.deleteItem(id);
    }

    @PostMapping("/items")
    private Long addItem(@RequestBody Items item){
        itemsService.addItem(item);
        return item.getItemId();
    }

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }
}
