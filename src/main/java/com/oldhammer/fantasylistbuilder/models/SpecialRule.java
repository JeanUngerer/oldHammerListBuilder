package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialRule {

    Long id;

    String name;

    AllBooks book;

    String phaseOfApplication;

    String ruleText;
}
