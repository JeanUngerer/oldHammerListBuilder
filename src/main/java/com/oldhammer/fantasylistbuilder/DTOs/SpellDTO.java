package com.oldhammer.fantasylistbuilder.DTOs;

import com.oldhammer.fantasylistbuilder.constants.SpellTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpellDTO {

    Long id;

    String name;

    AllBooksDTO book;

    private SpellTypes type;

    String effects;

    int wheeleNumber;

    boolean improvable;

    int castingValue;

    int augmentedCastingValue;
}
