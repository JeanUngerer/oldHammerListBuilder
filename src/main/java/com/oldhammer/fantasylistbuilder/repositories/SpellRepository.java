package com.oldhammer.fantasylistbuilder.repositories;

import com.oldhammer.fantasylistbuilder.entities.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository  extends JpaRepository<SpellEntity, Long> {
}
