package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitRuleRelationDTO {

    Long id;

    UnitDTO unit;

    SpecialRuleDTO specialRule;

    int cost;

    boolean optional;
}
