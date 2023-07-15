package com.oldhammer.fantasylistbuilder.entities;

import com.oldhammer.fantasylistbuilder.constants.GameType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "armyList")
public class ArmyListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Column(name = "pointsLimit", unique = true, nullable = false)
    int pointsLimit;

    @Column(name = "comment", unique = true, nullable = false)
    String comment;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "selection_id")
    List<UnitSelectionEntity> unitsSelection;


}
