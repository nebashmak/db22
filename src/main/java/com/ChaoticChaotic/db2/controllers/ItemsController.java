package com.ChaoticChaotic.db2.controllers;


import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.services.impl.ItemsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    ItemsImpl itemsImpl;

    @GetMapping("/items")
    private List<Items> showItems(){
      return itemsImpl.showItems();
    }

    @DeleteMapping("/items/{id}")
    private void deleteItem(@RequestParam("id") Long id){
        itemsImpl.deleteItem(id);
    }

    @PostMapping("/items")
    private Long addItem(@RequestBody Items item){
        itemsImpl.addItem(item);
        return item.getItemId();
    }
}
