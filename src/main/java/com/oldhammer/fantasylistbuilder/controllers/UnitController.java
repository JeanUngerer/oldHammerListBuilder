package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.UnitMapper;
import com.oldhammer.fantasylistbuilder.services.UnitService;
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
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    @Autowired
    TokenService tokenService;

    private UnitMapper unitMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/units")
    public ResponseEntity<List<UnitDTO>> getUnits() {
        return ResponseEntity.ok(unitMapper.modelsToDtos(unitService.findAllUnit()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UnitDTO> getUnitById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitMapper.modelToDto(unitService.findUnitById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<UnitDTO> create(@RequestBody UnitDTO unitDto) {
        return ResponseEntity.ok(unitMapper.modelToDto(unitService.createUnit(unitDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<UnitDTO> update(@RequestBody UnitDTO unitDto) {
        return ResponseEntity.ok(unitMapper.modelToDto(unitService.updateUnit(unitDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(unitService.deleteUnit(id));
    }
}
