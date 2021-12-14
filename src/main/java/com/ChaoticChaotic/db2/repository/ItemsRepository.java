package com.ChaoticChaotic.db2.repository;

import com.ChaoticChaotic.db2.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
    @Query(nativeQuery = true, value = "select * from items where name = :name")
    Items findByName(@Param("name") String name);

}
