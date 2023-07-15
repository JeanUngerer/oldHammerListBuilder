package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MountRuleRelation {

    Long id;

    Mount mount;

    SpecialRule rule;

    int cost;

    boolean optional;
}
