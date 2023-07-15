package com.oldhammer.fantasylistbuilder.models;

import com.oldhammer.fantasylistbuilder.constants.GameType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArmyList {

    Long id;

    String name;

    int pointsLimit;

    String comment;

    private GameType gameType;

    List<UnitSelection> unitsSelection;
}
