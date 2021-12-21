package com.ChaoticChaotic.db2.repository;

import com.ChaoticChaotic.db2.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {

}
