package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Items;
import java.util.List;

public interface ItemsService {
    void deleteItem(Long id);
    List<Items> showItems();
    void addItem(Items item);
}
