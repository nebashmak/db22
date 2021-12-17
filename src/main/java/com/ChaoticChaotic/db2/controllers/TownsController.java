package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.services.impl.TownsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TownsController {

    @Autowired
    TownsImpl townsimpl;

    @GetMapping("/towns")
    private List<Towns> showTowns(){
        return townsimpl.showTowns();
    }

    @DeleteMapping("/towns/{id}")
    private void deleteTown(@PathVariable("id") Long id){
        townsimpl.deleteTown(id);
    }

    @PostMapping("/towns")
    private Long addTown(@RequestBody Towns town){
        townsimpl.addTown(town);
        return town.getTownId();
    }
}
