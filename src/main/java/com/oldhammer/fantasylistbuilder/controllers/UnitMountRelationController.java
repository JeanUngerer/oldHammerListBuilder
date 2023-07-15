package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitMountRelationDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.UnitMountRelationMapper;
import com.oldhammer.fantasylistbuilder.services.UnitMountRelationService;
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
@RequestMapping("unitMountRelation")
public class UnitMountRelationController {

    @Autowired
    UnitMountRelationService unitMountRelationService;

    @Autowired
    TokenService tokenService;

    private UnitMountRelationMapper unitMountRelationMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/unitMountRelations")
    public ResponseEntity<List<UnitMountRelationDTO>> getUnitMountRelations() {
        return ResponseEntity.ok(unitMountRelationMapper.modelsToDtos(unitMountRelationService.findAllUnitMountRelation()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UnitMountRelationDTO> getUnitMountRelationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitMountRelationMapper.modelToDto(unitMountRelationService.findUnitMountRelationById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<UnitMountRelationDTO> create(@RequestBody UnitMountRelationDTO unitMountRelationDto) {
        return ResponseEntity.ok(unitMountRelationMapper.modelToDto(unitMountRelationService.createUnitMountRelation(unitMountRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<UnitMountRelationDTO> update(@RequestBody UnitMountRelationDTO unitMountRelationDto) {
        return ResponseEntity.ok(unitMountRelationMapper.modelToDto(unitMountRelationService.updateUnitMountRelation(unitMountRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitMountRelationService.deleteUnitMountRelation(id));
    }
}
