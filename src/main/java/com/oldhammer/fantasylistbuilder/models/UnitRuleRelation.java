package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitRuleRelation {

    Long id;

    Unit unit;

    SpecialRule specialRule;

    int cost;

    boolean optional;
}
