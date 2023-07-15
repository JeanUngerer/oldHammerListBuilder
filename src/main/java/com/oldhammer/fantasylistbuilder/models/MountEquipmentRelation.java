package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MountEquipmentRelation {

    Long id;

    Mount mount;

    Equipment equipment;

    int cost;

    boolean optional;
}
