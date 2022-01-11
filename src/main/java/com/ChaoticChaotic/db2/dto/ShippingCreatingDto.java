package com.ChaoticChaotic.db2.dto;

import java.time.LocalDate;
import java.util.Set;

public class ShippingCreatingDto {

    private LocalDate startDate;

    private LocalDate endDate;

    private TownDto town;

    private Set<ItemDto> item;

}
