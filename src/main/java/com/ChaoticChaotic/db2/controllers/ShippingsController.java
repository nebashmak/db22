package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.services.ShippingsService;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingsController {

    @Autowired
    private ShippingsService shippingsService;


    @GetMapping("/shippings")
    private List<Shippings> showShipping(){
        return shippingsService.showShipping();
    }

    @DeleteMapping("/shippings/{id}")
    private void deleteTown(@PathVariable("id") Long id){
        shippingsService.deleteShipping(id);
    }

    @PostMapping("/shippings")
    private Long addShipping(@RequestBody Shippings shipping){
        shippingsService.addShipping(shipping);
        return shipping.getShippingId();
    }

    public ShippingsController(ShippingsImpl shippingsService) {
        this.shippingsService = shippingsService;
    }

}
