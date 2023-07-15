package com.oldhammer.fantasylistbuilder.repositories;

import com.oldhammer.fantasylistbuilder.entities.ArmyListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmyListRepository  extends JpaRepository<ArmyListEntity, Long> {
}
