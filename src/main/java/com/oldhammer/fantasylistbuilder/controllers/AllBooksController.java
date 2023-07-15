package com.oldhammer.fantasylistbuilder.controllers;

import com.oldhammer.fantasylistbuilder.DTOs.AllBooksDTO;
import com.oldhammer.fantasylistbuilder.auth.service.TokenService;
import com.oldhammer.fantasylistbuilder.mappers.AllBooksMapper;
import com.oldhammer.fantasylistbuilder.services.AllBooksService;
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
@RequestMapping("allBooks")
public class AllBooksController {
    @Autowired
    AllBooksService allBooksService;

    @Autowired
    TokenService tokenService;

    private AllBooksMapper allBooksMapper;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Full CRUD for admin
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/allBookss")
    public ResponseEntity<List<AllBooksDTO>> getAllBookss() {
        return ResponseEntity.ok(allBooksMapper.modelsToDtos(allBooksService.findAllAllBooks()));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<AllBooksDTO> getAllBooksById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(allBooksMapper.modelToDto(allBooksService.findAllBooksById(id)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/create")
    public ResponseEntity<AllBooksDTO> create(@RequestBody AllBooksDTO allBooksDto) {
        return ResponseEntity.ok(allBooksMapper.modelToDto(allBooksService.createAllBooks(allBooksDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("update")
    public ResponseEntity<AllBooksDTO> update(@RequestBody AllBooksDTO allBooksDto) {
        return ResponseEntity.ok(allBooksMapper.modelToDto(allBooksService.updateAllBooks(allBooksDto)));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(allBooksService.deleteAllBooks(id));
    }
}
