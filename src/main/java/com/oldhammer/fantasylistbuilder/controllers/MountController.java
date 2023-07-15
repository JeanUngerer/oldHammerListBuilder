package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.MountDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.MountMapper;
import com.oldhammer.fantasylistbuilder.services.MountService;
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
@RequestMapping("mount")
public class MountController {

    @Autowired
    MountService mountService;

    @Autowired
    TokenService tokenService;

    private MountMapper mountMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/mounts")
    public ResponseEntity<List<MountDTO>> getMounts() {
        return ResponseEntity.ok(mountMapper.modelsToDtos(mountService.findAllMount()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MountDTO> getMountById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountMapper.modelToDto(mountService.findMountById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<MountDTO> create(@RequestBody MountDTO mountDto) {
        return ResponseEntity.ok(mountMapper.modelToDto(mountService.createMount(mountDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<MountDTO> update(@RequestBody MountDTO mountDto) {
        return ResponseEntity.ok(mountMapper.modelToDto(mountService.updateMount(mountDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mountService.deleteMount(id));
    }
}
