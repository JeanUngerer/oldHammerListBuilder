package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.SpecialRuleDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.SpecialRuleMapper;
import com.oldhammer.fantasylistbuilder.services.SpecialRuleService;
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
@RequestMapping("specialRule")
public class SpecialRuleController {

    @Autowired
    SpecialRuleService specialRuleService;

    @Autowired
    TokenService tokenService;

    private SpecialRuleMapper specialRuleMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/specialRules")
    public ResponseEntity<List<SpecialRuleDTO>> getSpecialRules() {
        return ResponseEntity.ok(specialRuleMapper.modelsToDtos(specialRuleService.findAllSpecialRule()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SpecialRuleDTO> getSpecialRuleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(specialRuleMapper.modelToDto(specialRuleService.findSpecialRuleById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<SpecialRuleDTO> create(@RequestBody SpecialRuleDTO specialRuleDto) {
        return ResponseEntity.ok(specialRuleMapper.modelToDto(specialRuleService.createSpecialRule(specialRuleDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<SpecialRuleDTO> update(@RequestBody SpecialRuleDTO specialRuleDto) {
        return ResponseEntity.ok(specialRuleMapper.modelToDto(specialRuleService.updateSpecialRule(specialRuleDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(specialRuleService.deleteSpecialRule(id));
    }
}
