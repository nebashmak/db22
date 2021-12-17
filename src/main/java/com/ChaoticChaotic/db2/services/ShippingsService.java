package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Shippings;

import java.util.List;


public interface ShippingsService {
    String addShipping(Shippings shipping);
    String deleteShipping(Long id);
    List<Shippings> showShipping();
}
