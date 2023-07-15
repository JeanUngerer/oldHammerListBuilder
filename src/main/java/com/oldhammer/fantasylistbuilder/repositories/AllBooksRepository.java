package com.oldhammer.fantasylistbuilder.repositories;

import com.oldhammer.fantasylistbuilder.entities.AllBooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllBooksRepository  extends JpaRepository<AllBooksEntity, Long> {
}
