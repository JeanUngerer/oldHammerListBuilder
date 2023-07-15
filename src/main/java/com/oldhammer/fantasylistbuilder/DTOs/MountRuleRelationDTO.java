package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MountRuleRelationDTO {

    Long id;

    MountDTO mount;

    SpecialRuleDTO rule;

    int cost;

    boolean optional;
}
