package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitSelection {

    Long id;

    String name;

    Unit unit;

    int modelCount;

    UnitMountRelation selectedMount;

    List<UnitEquipmentRelation> equipments;

    List<UnitRuleRelation> specialRules;

    List<MountEquipmentRelation> mountEquipments;
    
    List<MountRuleRelation> mountSpecialRules;
}
