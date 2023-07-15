package com.oldhammer.fantasylistbuilder.entities;

import com.oldhammer.fantasylistbuilder.constants.UnitCategories;
import com.oldhammer.fantasylistbuilder.constants.UnitTypes;
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
@Table(name = "units")
public class UnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    private UnitTypes type;

    @Enumerated(EnumType.STRING)
    private UnitCategories category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    AllBooksEntity book;

    @Column(name = "named", nullable = false)
    boolean named;

    @Column(name = "defaultMount", nullable = false)
    boolean defaultMount;

    @Column(name = "movement", nullable = false)
    int movement;

    @Column(name = "closeCombatSkill", nullable = false)
    int closeCombatSkill;

    @Column(name = "shootingSkill", nullable = false)
    int shootingSkill;

    @Column(name = "strength", nullable = false)
    int strength;

    @Column(name = "toughness", nullable = false)
    int toughness;

    @Column(name = "wounds", nullable = false)
    int wounds;

    @Column(name = "initiative", nullable = false)
    int initiative;

    @Column(name = "attacks", nullable = false)
    int attacks;

    @Column(name = "leadership", nullable = false)
    int leadership;

    @Column(name = "baseArmor", nullable = false)
    int baseArmor;

    @Column(name = "baseInvul", nullable = false)
    int baseInvul;

    @Column(name = "magicLevel", nullable = false)
    int magicLevel;

    @Column(name = "baseCost", nullable = false)
    int baseCost;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "magicDomain_id")
    List<MagicDomainEntity> magicDomain;

    @Column(name = "minimumModelCount")
    int minimumModelCount;

    @Column(name = "isCharacter")
    boolean isCharacter;
}
