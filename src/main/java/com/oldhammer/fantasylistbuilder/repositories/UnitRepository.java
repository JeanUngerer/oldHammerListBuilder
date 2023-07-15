package com.oldhammer.fantasylistbuilder.repositories;

import com.oldhammer.fantasylistbuilder.entities.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository  extends JpaRepository<UnitEntity, Long> {
}
