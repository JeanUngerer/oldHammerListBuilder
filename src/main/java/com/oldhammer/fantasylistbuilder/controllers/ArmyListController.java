package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.ArmyListDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.ArmyListMapper;
import com.oldhammer.fantasylistbuilder.services.ArmyListService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@RequestMapping("armyList")
public class ArmyListController {

    @Autowired
    ArmyListService armyListService;

    @Autowired
    TokenService tokenService;

    private ArmyListMapper armyListMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/armyLists")
    public ResponseEntity<List<ArmyListDTO>> getArmyLists() {
        return ResponseEntity.ok(armyListMapper.modelsToDtos(armyListService.findAllArmyList()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ArmyListDTO> getArmyListById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(armyListMapper.modelToDto(armyListService.findArmyListById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<ArmyListDTO> create(@RequestBody ArmyListDTO armyListDto) {
        return ResponseEntity.ok(armyListMapper.modelToDto(armyListService.createArmyList(armyListDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<ArmyListDTO> update(@RequestBody ArmyListDTO armyListDto) {
        return ResponseEntity.ok(armyListMapper.modelToDto(armyListService.updateArmyList(armyListDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(armyListService.deleteArmyList(id));
    }
}
