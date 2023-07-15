package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitSelectionDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.UnitSelectionMapper;
import com.oldhammer.fantasylistbuilder.services.UnitSelectionService;
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
@RequestMapping("unitSelection")
public class UnitSelectionController {

    @Autowired
    UnitSelectionService unitSelectionService;

    @Autowired
    TokenService tokenService;

    private UnitSelectionMapper unitSelectionMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/unitSelections")
    public ResponseEntity<List<UnitSelectionDTO>> getUnitSelections() {
        return ResponseEntity.ok(unitSelectionMapper.modelsToDtos(unitSelectionService.findAllUnitSelection()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UnitSelectionDTO> getUnitSelectionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitSelectionMapper.modelToDto(unitSelectionService.findUnitSelectionById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<UnitSelectionDTO> create(@RequestBody UnitSelectionDTO unitSelectionDto) {
        return ResponseEntity.ok(unitSelectionMapper.modelToDto(unitSelectionService.createUnitSelection(unitSelectionDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<UnitSelectionDTO> update(@RequestBody UnitSelectionDTO unitSelectionDto) {
        return ResponseEntity.ok(unitSelectionMapper.modelToDto(unitSelectionService.updateUnitSelection(unitSelectionDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitSelectionService.deleteUnitSelection(id));
    }
}
