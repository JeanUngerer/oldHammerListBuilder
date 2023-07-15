package com.oldhammer.fantasylistbuilder.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {

    Long id;

    String name;

    String type;

    String effects;

    AllBooksDTO book;

    List<SpecialRuleDTO> specialRules;
}
