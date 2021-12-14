package com.ChaoticChaotic.db2.services.impl;


import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import com.ChaoticChaotic.db2.services.TownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class TownsImpl implements TownsService {

    @Autowired
    private TownsRepository townsRepository;

    @Autowired
    private ShippingsRepository shippingsRepository;


    @PostMapping("/towns")
    public void addTown(Towns town) {
    townsRepository.save(town);
    }

    @DeleteMapping("/towns")
    public void deleteTown(Long id) {
        if(!(shippingsRepository.findById(id).isPresent())) {
            townsRepository.deleteById(id);
        }
    }

    @GetMapping("/towns")
    public void showTowns() {
        List<Towns> allTowns = new ArrayList<>();
        townsRepository.findAll().forEach(town -> allTowns.add(town));
        for(Towns town: allTowns)
            System.out.println(town.toString());
    }
}
