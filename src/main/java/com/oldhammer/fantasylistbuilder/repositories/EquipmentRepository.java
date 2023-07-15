package com.oldhammer.fantasylistbuilder.repositories;

import com.oldhammer.fantasylistbuilder.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository  extends JpaRepository<EquipmentEntity, Long> {
}
