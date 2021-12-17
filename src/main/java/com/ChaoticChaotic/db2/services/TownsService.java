package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Towns;

import java.util.List;

public interface TownsService {
    String addTown(Towns town);
    String deleteTown(Long id);
    List<Towns> showTowns();
}
