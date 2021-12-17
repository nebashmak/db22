package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingsController {

    @Autowired
    ShippingsImpl shippingsImpl;

    @GetMapping("/shippings")
    private List<Shippings> showShipping(){
        return shippingsImpl.showShipping();
    }

    @DeleteMapping("/shippings/{id}")
    private void deleteTown(@RequestParam("id") Long id){
        shippingsImpl.deleteShipping(id);
    }

    @PostMapping("/shippings")
    private Long addShipping(@RequestBody Shippings shipping){
        shippingsImpl.addShipping(shipping);
        return shipping.getShippingId();
    }

}
