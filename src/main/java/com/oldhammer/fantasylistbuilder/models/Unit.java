package com.oldhammer.fantasylistbuilder.models;

import com.oldhammer.fantasylistbuilder.constants.UnitCategories;
import com.oldhammer.fantasylistbuilder.constants.UnitTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    Long id;

    String name;

    private UnitTypes type;

    private UnitCategories category;

    AllBooks book;

    boolean named;

    boolean defaultMount;

    int movement;

    int closeCombatSkill;

    int shootingSkill;

    int strength;

    int toughness;

    int wounds;

    int initiative;

    int attacks;

    int leadership;

    int baseArmor;

    int baseInvul;

    int magicLevel;

    int baseCost;

    List<MagicDomain> magicDomain;

    int minimumModelCount;

    boolean isCharacter;
}
