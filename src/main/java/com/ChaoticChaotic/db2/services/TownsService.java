package com.ChaoticChaotic.db2.services;


import com.ChaoticChaotic.db2.entity.Towns;

public interface TownsService {
    void addTown(Towns town);
    void deleteTown(Long id);
    void showTowns();
}
