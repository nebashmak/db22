package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Items;
import java.util.List;

public interface ItemsService {
    String deleteItem(Long id);
    List<Items> showItems();
    String addItem(Items item);
}
