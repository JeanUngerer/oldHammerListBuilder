package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitSelectionDTO {

    Long id;

    String name;

    UnitDTO unit;

    int modelCount;

    UnitMountRelationDTO selectedMount;

    List<UnitEquipmentRelationDTO> equipments;

    List<UnitRuleRelationDTO> specialRules;

    List<MountEquipmentRelationDTO> mountEquipments;
    
    List<MountRuleRelationDTO> mountSpecialRules;
}
