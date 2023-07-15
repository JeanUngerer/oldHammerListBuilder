package com.oldhammer.fantasylistbuilder.models;

import com.oldhammer.fantasylistbuilder.constants.SpellTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spell {

    Long id;

    String name;

    AllBooks book;

    private SpellTypes type;

    String effects;

    int wheeleNumber;

    boolean improvable;

    int castingValue;

    int augmentedCastingValue;
}
