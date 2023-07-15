package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.MagicDomainDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.MagicDomainMapper;
import com.oldhammer.fantasylistbuilder.services.MagicDomainService;
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
@RequestMapping("magicDomain")
public class MagicDomainController {

    @Autowired
    MagicDomainService magicDomainService;

    @Autowired
    TokenService tokenService;

    private MagicDomainMapper magicDomainMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/magicDomains")
    public ResponseEntity<List<MagicDomainDTO>> getMagicDomains() {
        return ResponseEntity.ok(magicDomainMapper.modelsToDtos(magicDomainService.findAllMagicDomain()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<MagicDomainDTO> getMagicDomainById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(magicDomainMapper.modelToDto(magicDomainService.findMagicDomainById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<MagicDomainDTO> create(@RequestBody MagicDomainDTO magicDomainDto) {
        return ResponseEntity.ok(magicDomainMapper.modelToDto(magicDomainService.createMagicDomain(magicDomainDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<MagicDomainDTO> update(@RequestBody MagicDomainDTO magicDomainDto) {
        return ResponseEntity.ok(magicDomainMapper.modelToDto(magicDomainService.updateMagicDomain(magicDomainDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(magicDomainService.deleteMagicDomain(id));
    }
}
