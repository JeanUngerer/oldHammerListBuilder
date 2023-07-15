package com.oldhammer.fantasylistbuilder.entities;

import com.oldhammer.fantasylistbuilder.constants.MountType;
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
@Table(name = "mounts")
public class MountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mount_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Enumerated(EnumType.STRING)
    private MountType mountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    AllBooksEntity book;

    @Column(name = "named", nullable = false)
    boolean named;

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
    
    
}
