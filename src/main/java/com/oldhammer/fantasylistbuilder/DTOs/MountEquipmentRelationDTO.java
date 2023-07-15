package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MountEquipmentRelationDTO {

    Long id;

    MountDTO mount;

    EquipmentDTO equipment;

    int cost;

    boolean optional;
}
