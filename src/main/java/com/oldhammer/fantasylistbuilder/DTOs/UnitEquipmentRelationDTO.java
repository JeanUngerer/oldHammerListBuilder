package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitEquipmentRelationDTO {

    Long id;

    UnitDTO unit;

    EquipmentDTO equipment;

    int cost;

    boolean optional;
}
