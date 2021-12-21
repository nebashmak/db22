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
    private ShippingsService shippingsImpl;


    @GetMapping("/shippings")
    private List<Shippings> showShipping(){
        return shippingsImpl.showShipping();
    }

    @DeleteMapping("/shippings/{id}")
    private void deleteTown(@PathVariable("id") Long id){
        shippingsImpl.deleteShipping(id);
    }

    @PostMapping("/shippings")
    private Long addShipping(@RequestBody Shippings shipping){
        shippingsImpl.addShipping(shipping);
        return shipping.getShippingId();
    }

    public ShippingsController(ShippingsImpl shippingsImpl) {
        this.shippingsImpl = shippingsImpl;
    }

}
