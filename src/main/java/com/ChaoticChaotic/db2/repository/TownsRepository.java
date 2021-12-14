package com.ChaoticChaotic.db2.repository;

import com.ChaoticChaotic.db2.entity.Towns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownsRepository extends JpaRepository<Towns,Long> {
}
