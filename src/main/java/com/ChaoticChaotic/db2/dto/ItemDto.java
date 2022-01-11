package com.ChaoticChaotic.db2.dto;

import com.ChaoticChaotic.db2.entity.Shipping;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class ItemDto {

    private String name;

    private Long quantity;

}
