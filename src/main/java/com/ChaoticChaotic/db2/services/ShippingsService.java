package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Shippings;

import java.util.List;


public interface ShippingsService {
    void addShipping(Shippings shipping);
    void deleteShipping(Long id);
    List<Shippings> showShipping();
}
