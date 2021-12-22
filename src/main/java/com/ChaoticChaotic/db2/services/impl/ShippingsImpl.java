package com.ChaoticChaotic.db2.services.impl;

import com.ChaoticChaotic.db2.entity.Shippings;
import com.ChaoticChaotic.db2.exception.BadRequestException;
import com.ChaoticChaotic.db2.exception.IdNotFoundException;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.services.ShippingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingsImpl implements ShippingsService {

    @Autowired
    private ShippingsRepository shippingsRepository;

    public void addShipping(Shippings shipping) {
    if (!shipping.getStartDate().isBefore(shipping.getEndDate())){
            throw new BadRequestException(
                    "Incorrect shipping dates!"
            );
        }
        shippingsRepository.save(shipping);
    }

    public void deleteShipping(Long id) {
        if(!shippingsRepository.existsById(id)) {
            throw new IdNotFoundException(
                    "Line with id " + id + " does not exists");
        }
        shippingsRepository.deleteById(id);
    }

    public List<Shippings> showShipping() {
        return shippingsRepository.findAll();
    }

    public ShippingsImpl(ShippingsRepository shippingsRepository) {
        this.shippingsRepository = shippingsRepository;
    }

}
