package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitEquipmentRelation {

    Long id;

    Unit unit;

    Equipment equipment;

    int cost;

    boolean optional;
}
