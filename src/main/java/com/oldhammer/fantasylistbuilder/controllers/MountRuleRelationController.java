package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.MountRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.MountRuleRelationMapper;
import com.oldhammer.fantasylistbuilder.services.MountRuleRelationService;
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
@RequestMapping("mountRuleRelation")
public class MountRuleRelationController {

    @Autowired
    MountRuleRelationService mountRuleRelationService;

    @Autowired
    TokenService tokenService;

    private MountRuleRelationMapper mountRuleRelationMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/mountRuleRelations")
    public ResponseEntity<List<MountRuleRelationDTO>> getMountRuleRelations() {
        return ResponseEntity.ok(mountRuleRelationMapper.modelsToDtos(mountRuleRelationService.findAllMountRuleRelation()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MountRuleRelationDTO> getMountRuleRelationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountRuleRelationMapper.modelToDto(mountRuleRelationService.findMountRuleRelationById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<MountRuleRelationDTO> create(@RequestBody MountRuleRelationDTO mountRuleRelationDto) {
        return ResponseEntity.ok(mountRuleRelationMapper.modelToDto(mountRuleRelationService.createMountRuleRelation(mountRuleRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<MountRuleRelationDTO> update(@RequestBody MountRuleRelationDTO mountRuleRelationDto) {
        return ResponseEntity.ok(mountRuleRelationMapper.modelToDto(mountRuleRelationService.updateMountRuleRelation(mountRuleRelationDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountRuleRelationService.deleteMountRuleRelation(id));
    }
}
