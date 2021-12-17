package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ShippingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingsImpl implements ShippingsService {

    @Autowired
    private ShippingsRepository shippingsRepository;


    public String addShipping(Shippings shipping) {
    if (shipping.getStartDate().isBefore(shipping.getEndDate())){
       shippingsRepository.save(shipping);
        }
        return "Saved";
    }


    public String deleteShipping(Long id) {
    shippingsRepository.deleteById(id);
        return "Deleted";
    }


    public List<Shippings> showShipping() {
        List<Shippings> allShippings = new ArrayList<>();
        shippingsRepository.findAll().forEach(shipping -> allShippings.add(shipping));
        return allShippings;
    }
}
