package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.SpellDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.SpellMapper;
import com.oldhammer.fantasylistbuilder.services.SpellService;
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
@RequestMapping("spell")
public class SpellController {

    @Autowired
    SpellService spellService;

    @Autowired
    TokenService tokenService;

    private SpellMapper spellMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/spells")
    public ResponseEntity<List<SpellDTO>> getSpells() {
        return ResponseEntity.ok(spellMapper.modelsToDtos(spellService.findAllSpell()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SpellDTO> getSpellById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(spellMapper.modelToDto(spellService.findSpellById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<SpellDTO> create(@RequestBody SpellDTO spellDto) {
        return ResponseEntity.ok(spellMapper.modelToDto(spellService.createSpell(spellDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<SpellDTO> update(@RequestBody SpellDTO spellDto) {
        return ResponseEntity.ok(spellMapper.modelToDto(spellService.updateSpell(spellDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(spellService.deleteSpell(id));
    }
}
