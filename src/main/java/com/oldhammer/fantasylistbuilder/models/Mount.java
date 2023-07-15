package com.oldhammer.fantasylistbuilder.models;

import com.oldhammer.fantasylistbuilder.constants.MountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mount {

    Long id;

    String name;

    private MountType mountType;

    AllBooks book;

    boolean named;

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
}
