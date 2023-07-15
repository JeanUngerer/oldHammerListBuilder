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
@Table(name = "magicDomains")
public class MagicDomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "magicDomain_id", unique = true, nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Column(name = "domainAttribute", unique = true, nullable = false)
    String domainAttribute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    AllBooksEntity book;
}
