package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitMountRelationDTO {

    Long id;

    UnitDTO unit;

    MountDTO mount;

    int cost;

    boolean optional;
}
