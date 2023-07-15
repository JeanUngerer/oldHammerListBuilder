package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.UnitEquipmentRelationMapper;
import com.oldhammer.fantasylistbuilder.services.UnitEquipmentRelationService;
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
@RequestMapping("unitEquipmentRelation")
public class UnitEquipmentRelationController {

    @Autowired
    UnitEquipmentRelationService unitEquipmentRelationService;

    @Autowired
    TokenService tokenService;

    private UnitEquipmentRelationMapper unitEquipmentRelationMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/unitEquipmentRelations")
    public ResponseEntity<List<UnitEquipmentRelationDTO>> getUnitEquipmentRelations() {
        return ResponseEntity.ok(unitEquipmentRelationMapper.modelsToDtos(unitEquipmentRelationService.findAllUnitEquipmentRelation()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UnitEquipmentRelationDTO> getUnitEquipmentRelationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitEquipmentRelationMapper.modelToDto(unitEquipmentRelationService.findUnitEquipmentRelationById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<UnitEquipmentRelationDTO> create(@RequestBody UnitEquipmentRelationDTO unitEquipmentRelationDto) {
        return ResponseEntity.ok(unitEquipmentRelationMapper.modelToDto(unitEquipmentRelationService.createUnitEquipmentRelation(unitEquipmentRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<UnitEquipmentRelationDTO> update(@RequestBody UnitEquipmentRelationDTO unitEquipmentRelationDto) {
        return ResponseEntity.ok(unitEquipmentRelationMapper.modelToDto(unitEquipmentRelationService.updateUnitEquipmentRelation(unitEquipmentRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitEquipmentRelationService.deleteUnitEquipmentRelation(id));
    }
}
