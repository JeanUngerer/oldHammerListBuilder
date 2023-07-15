package com.oldhammer.fantasylistbuilder.entities;

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
@Table(name = "mountEquipmentRelations")
public class MountEquipmentRelationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mount_id")
    MountEntity mount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    EquipmentEntity equipment;

    @Column(name = "cost", unique = true, nullable = false)
    int cost;

    @Column(name = "optional", unique = true, nullable = false)
    boolean optional;
}
