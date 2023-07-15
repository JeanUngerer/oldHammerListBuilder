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
public class Equipment {

    Long id;

    String name;

    String type;

    String effects;

    AllBooks book;

    List<SpecialRule> specialRules;
}
