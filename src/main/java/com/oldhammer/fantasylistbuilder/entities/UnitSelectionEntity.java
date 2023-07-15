package com.oldhammer.fantasylistbuilder.entities;

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
@Table(name = "unitSelection")
public class UnitSelectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "selection_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    UnitEntity unit;

    @Column(name = "modelCount", unique = true, nullable = false)
    int modelCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    UnitMountRelationEntity selectedMount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    List<UnitEquipmentRelationEntity> equipments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    List<UnitRuleRelationEntity> specialRules;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    List<MountEquipmentRelationEntity> mountEquipments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    List<MountRuleRelationEntity> mountSpecialRules;
}
