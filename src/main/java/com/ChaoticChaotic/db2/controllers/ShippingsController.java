package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.dto.ShippingCreatingDto;
import com.ChaoticChaotic.db2.entity.Shipping;
import com.ChaoticChaotic.db2.services.ShippingsService;
import com.ChaoticChaotic.db2.services.impl.ShippingsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippingsController {

    @Autowired
    private ShippingsService shippingsService;


    @GetMapping("/shippings")
    private List<Shipping> showShipping() {
        return shippingsService.showShipping();
    }

    @DeleteMapping("/shippings/{id}")
    private void deleteTown(@PathVariable("id") Long id) {
        shippingsService.deleteShipping(id);
    }

    @PostMapping("/shippings")
    private Long createShipping(@RequestBody ShippingCreatingDto creatingRequest) {
        Long newShippingId = shippingsService.addShipping(creatingRequest);
        return newShippingId;
    }

    public ShippingsController(ShippingsImpl shippingsService) {
        this.shippingsService = shippingsService;
    }

}
