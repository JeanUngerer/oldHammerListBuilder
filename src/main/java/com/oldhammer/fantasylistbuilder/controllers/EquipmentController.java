package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.EquipmentDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.EquipmentMapper;
import com.oldhammer.fantasylistbuilder.services.EquipmentService;
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
@RequestMapping("equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    TokenService tokenService;

    private EquipmentMapper equipmentMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/equipments")
    public ResponseEntity<List<EquipmentDTO>> getEquipments() {
        return ResponseEntity.ok(equipmentMapper.modelsToDtos(equipmentService.findAllEquipment()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(equipmentMapper.modelToDto(equipmentService.findEquipmentById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<EquipmentDTO> create(@RequestBody EquipmentDTO equipmentDto) {
        return ResponseEntity.ok(equipmentMapper.modelToDto(equipmentService.createEquipment(equipmentDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<EquipmentDTO> update(@RequestBody EquipmentDTO equipmentDto) {
        return ResponseEntity.ok(equipmentMapper.modelToDto(equipmentService.updateEquipment(equipmentDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(equipmentService.deleteEquipment(id));
    }
}
