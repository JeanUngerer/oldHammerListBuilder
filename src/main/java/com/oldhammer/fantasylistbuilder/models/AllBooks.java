package com.oldhammer.fantasylistbuilder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AllBooks {

    Long id;

    String name;

    String version;

    String linkPath;
}
