package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.UnitRuleRelationMapper;
import com.oldhammer.fantasylistbuilder.services.UnitRuleRelationService;
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
@RequestMapping("unitRuleRelation")
public class UnitRuleRelationController {

    @Autowired
    UnitRuleRelationService unitRuleRelationService;

    @Autowired
    TokenService tokenService;

    private UnitRuleRelationMapper unitRuleRelationMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/unitRuleRelations")
    public ResponseEntity<List<UnitRuleRelationDTO>> getUnitRuleRelations() {
        return ResponseEntity.ok(unitRuleRelationMapper.modelsToDtos(unitRuleRelationService.findAllUnitRuleRelation()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UnitRuleRelationDTO> getUnitRuleRelationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitRuleRelationMapper.modelToDto(unitRuleRelationService.findUnitRuleRelationById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<UnitRuleRelationDTO> create(@RequestBody UnitRuleRelationDTO unitRuleRelationDto) {
        return ResponseEntity.ok(unitRuleRelationMapper.modelToDto(unitRuleRelationService.createUnitRuleRelation(unitRuleRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<UnitRuleRelationDTO> update(@RequestBody UnitRuleRelationDTO unitRuleRelationDto) {
        return ResponseEntity.ok(unitRuleRelationMapper.modelToDto(unitRuleRelationService.updateUnitRuleRelation(unitRuleRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitRuleRelationService.deleteUnitRuleRelation(id));
    }
}
