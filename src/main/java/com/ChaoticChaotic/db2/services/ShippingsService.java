package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Shippings;

import java.util.Date;

public interface ShippingsService {
    void addShipping(Shippings shipping);
    void deleteShipping(Long shipping_id);
    void showShipping();
}
