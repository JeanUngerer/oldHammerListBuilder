package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.MountEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.MountEquipmentRelationMapper;
import com.oldhammer.fantasylistbuilder.services.MountEquipmentRelationService;
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
@RequestMapping("mountEquipmentRelation")
public class MountEquipmentRelationController {

    @Autowired
    MountEquipmentRelationService mountEquipmentRelationService;

    @Autowired
    TokenService tokenService;

    private MountEquipmentRelationMapper mountEquipmentRelationMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/mountEquipmentRelations")
    public ResponseEntity<List<MountEquipmentRelationDTO>> getMountEquipmentRelations() {
        return ResponseEntity.ok(mountEquipmentRelationMapper.modelsToDtos(mountEquipmentRelationService.findAllMountEquipmentRelation()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MountEquipmentRelationDTO> getMountEquipmentRelationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountEquipmentRelationMapper.modelToDto(mountEquipmentRelationService.findMountEquipmentRelationById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<MountEquipmentRelationDTO> create(@RequestBody MountEquipmentRelationDTO mountEquipmentRelationDto) {
        return ResponseEntity.ok(mountEquipmentRelationMapper.modelToDto(mountEquipmentRelationService.createMountEquipmentRelation(mountEquipmentRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<MountEquipmentRelationDTO> update(@RequestBody MountEquipmentRelationDTO mountEquipmentRelationDto) {
        return ResponseEntity.ok(mountEquipmentRelationMapper.modelToDto(mountEquipmentRelationService.updateMountEquipmentRelation(mountEquipmentRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountEquipmentRelationService.deleteMountEquipmentRelation(id));
    }
}
