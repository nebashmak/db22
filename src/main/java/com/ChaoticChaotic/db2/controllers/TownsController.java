package com.ChaoticChaotic.db2.controllers;

import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.services.TownsService;
import com.ChaoticChaotic.db2.services.impl.TownsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TownsController {

    @Autowired
    private TownsService townsService;

    @GetMapping("/towns")
    private List<Towns> showTowns(){
        return townsService.showTowns();
    }

    @DeleteMapping("/towns/{id}")
    private void deleteTown(@PathVariable("id") Long id){
        townsService.deleteTown(id);
    }

    @PostMapping("/towns")
    private Long addTown(@RequestBody Towns town){
        townsService.addTown(town);
        return town.getTownId();
    }

    public TownsController(TownsImpl townsService) {
        this.townsService = townsService;
    }
}
