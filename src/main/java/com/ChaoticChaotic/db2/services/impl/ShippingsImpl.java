package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ShippingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingsImpl implements ShippingsService {

    @Autowired
    private ShippingsRepository shippingsRepository;

    @PostMapping("/shippings")
    public void addShipping(Shippings shipping) {
    if (shipping.getStartDate().toInstant().isBefore(shipping.getEndDate().toInstant())){
       shippingsRepository.save(shipping);
        }
    }

    @DeleteMapping("/shippings")
    public void deleteShipping(Long shipping_id) {
    shippingsRepository.deleteById(shipping_id);
    }

    @GetMapping("/shippings")
    public void showShipping() {
        List<Shippings> allShippings = new ArrayList<>();
        shippingsRepository.findAll().forEach(shipping -> allShippings.add(shipping));
        for(Shippings shipping: allShippings)
            System.out.println(shipping.toString());
    }
}
