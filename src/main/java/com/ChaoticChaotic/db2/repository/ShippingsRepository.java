package com.ChaoticChaotic.db2.repository;

import com.ChaoticChaotic.db2.entity.Shippings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingsRepository extends JpaRepository<Shippings,Long> {

}
