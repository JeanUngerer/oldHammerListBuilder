package com.oldhammer.fantasylistbuilder.entities;

import com.oldhammer.fantasylistbuilder.constants.SpellTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spells")
public class SpellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spell_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "magicDomain_id")
    AllBooksEntity book;

    @Enumerated(EnumType.STRING)
    private SpellTypes type;

    @Column(name = "effects", unique = true, nullable = false)
    String effects;

    @Column(name = "wheeleNumber", unique = true, nullable = false)
    int wheeleNumber;

    @Column(name = "improvable", unique = true, nullable = false)
    boolean improvable;

    @Column(name = "castingValue", unique = true, nullable = false)
    int castingValue;

    @Column(name = "augmentedCastingValue", unique = true)
    int augmentedCastingValue;
}
