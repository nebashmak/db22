package com.ChaoticChaotic.db2.services.impl;


import com.ChaoticChaotic.db2.entity.Towns;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import com.ChaoticChaotic.db2.services.TownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TownsImpl implements TownsService {

    @Autowired
    private TownsRepository townsRepository;
    @Autowired
    private ShippingsRepository shippingsRepository;


    public void addTown(Towns town) {
        townsRepository.save(town);
    }


    public void deleteTown(Long id) {
        if(!townsRepository.existsById(id)) {
            throw new IdNotFoundException(
                    "Line with id " + id + " does not exists");
        }
        townsRepository.deleteById(id);
    }


    public List<Towns> showTowns() {
        return townsRepository.findAll();
    }

    public TownsImpl(TownsRepository townsRepository, ShippingsRepository shippingsRepository) {
        this.townsRepository = townsRepository;
        this.shippingsRepository = shippingsRepository;
    }
}
