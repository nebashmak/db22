package com.ChaoticChaotic.db2.services.impl;


import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import com.ChaoticChaotic.db2.services.TownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TownsImpl implements TownsService {

    @Autowired
    private TownsRepository townsRepository;

    @Autowired
    private ShippingsRepository shippingsRepository;



    public String addTown(Towns town) {
        townsRepository.save(town);
        return "Saved";
    }


    public String deleteTown(Long id) {
        if(!(shippingsRepository.findById(id).isPresent())) {
            townsRepository.deleteById(id);
        }
        return "Deleted";
    }


    public List<Towns> showTowns() {
        List<Towns> allTowns = new ArrayList<>();
        townsRepository.findAll().forEach(town -> allTowns.add(town));
        return allTowns;
    }
}
