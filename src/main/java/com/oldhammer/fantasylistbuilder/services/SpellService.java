package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.SpellDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.SpellMapper;
import com.oldhammer.fantasylistbuilder.models.Spell;
import com.oldhammer.fantasylistbuilder.repositories.SpellRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
@Transactional
public class SpellService {
    SpellRepository spellRepository;

    SpellMapper spellMapper;

    public List<Spell> findAllSpell() {
        try {
            log.info("findAllSpell");
            List<Spell> spellList = new ArrayList<Spell>();
            spellRepository.findAll().forEach(ct -> spellList.add(spellMapper.entityToModel(ct)));
            return  spellList;
        } catch (Exception e) {
            log.error("We could not find all spell: " + e.getMessage());
            throw new ExceptionHandler("We could not find your spells");
        }
    }

    public Spell findSpellById(Long id) {
        try {
            log.info("findSpellById - id: " + id.toString());
            Spell spell = spellMapper.entityToModel(spellRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your spell")));
            return spell;
        } catch (Exception e) {
            log.error("We could not find all spell: " + e.getMessage());
            throw new ExceptionHandler("We could not find your spell");
        }
    }

    public Spell createSpell(SpellDTO dto) {
        try {
            log.info("createSpell");
            Spell spell = spellMapper.dtoToModel(dto);
            spellRepository.save(spellMapper.modelToEntity(spell));
            return spell;
        } catch (Exception e) {
            log.error("Couldn't spell user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your spell");
        }
    }
    public Spell updateSpell(SpellDTO dto) {
        try {
            log.info("updateSpell - id: " + dto.getId().toString());
            Spell spell = spellMapper.entityToModel(spellRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your spell")));
            spellMapper.updateFromDto(dto, spell, new CycleAvoidingMappingContext());
            spellRepository.save(spellMapper.modelToEntity(spell));
            return spell;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your spell");
        }
    }

    public String deleteSpell(Long id) {
        try {
            log.info("deleteSpell - id: " + id.toString());
            Spell spell = spellMapper.entityToModel(spellRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your spell")));
            spellRepository.delete(spellMapper.modelToEntity(spell));
            return "Spell deleted";
        } catch (Exception e) {
            log.error("Couldn't delete spell: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your spell");
        }
    }
}
