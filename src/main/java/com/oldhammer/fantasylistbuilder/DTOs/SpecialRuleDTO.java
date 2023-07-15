package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialRuleDTO {

    Long id;

    String name;

    AllBooksDTO book;

    String phaseOfApplication;

    String ruleText;
}
