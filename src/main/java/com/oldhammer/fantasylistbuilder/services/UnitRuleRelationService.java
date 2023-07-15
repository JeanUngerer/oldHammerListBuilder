package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.UnitRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.UnitRuleRelationMapper;
import com.oldhammer.fantasylistbuilder.models.UnitRuleRelation;
import com.oldhammer.fantasylistbuilder.repositories.UnitRuleRelationRepository;
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
public class UnitRuleRelationService {
    UnitRuleRelationRepository unitRuleRelationRepository;

    UnitRuleRelationMapper unitRuleRelationMapper;

    public List<UnitRuleRelation> findAllUnitRuleRelation() {
        try {
            log.info("findAllUnitRuleRelation");
            List<UnitRuleRelation> unitRuleRelationList = new ArrayList<UnitRuleRelation>();
            unitRuleRelationRepository.findAll().forEach(ct -> unitRuleRelationList.add(unitRuleRelationMapper.entityToModel(ct)));
            return  unitRuleRelationList;
        } catch (Exception e) {
            log.error("We could not find all unitRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitRuleRelations");
        }
    }

    public UnitRuleRelation findUnitRuleRelationById(Long id) {
        try {
            log.info("findUnitRuleRelationById - id: " + id.toString());
            UnitRuleRelation unitRuleRelation = unitRuleRelationMapper.entityToModel(unitRuleRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your unitRuleRelation")));
            return unitRuleRelation;
        } catch (Exception e) {
            log.error("We could not find all unitRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitRuleRelation");
        }
    }

    public UnitRuleRelation createUnitRuleRelation(UnitRuleRelationDTO dto) {
        try {
            log.info("createUnitRuleRelation");
            UnitRuleRelation unitRuleRelation = unitRuleRelationMapper.dtoToModel(dto);
            unitRuleRelationRepository.save(unitRuleRelationMapper.modelToEntity(unitRuleRelation));
            return unitRuleRelation;
        } catch (Exception e) {
            log.error("Couldn't unitRuleRelation user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your unitRuleRelation");
        }
    }
    public UnitRuleRelation updateUnitRuleRelation(UnitRuleRelationDTO dto) {
        try {
            log.info("updateUnitRuleRelation - id: " + dto.getId().toString());
            UnitRuleRelation unitRuleRelation = unitRuleRelationMapper.entityToModel(unitRuleRelationRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitRuleRelation")));
            unitRuleRelationMapper.updateFromDto(dto, unitRuleRelation, new CycleAvoidingMappingContext());
            unitRuleRelationRepository.save(unitRuleRelationMapper.modelToEntity(unitRuleRelation));
            return unitRuleRelation;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your unitRuleRelation");
        }
    }

    public String deleteUnitRuleRelation(Long id) {
        try {
            log.info("deleteUnitRuleRelation - id: " + id.toString());
            UnitRuleRelation unitRuleRelation = unitRuleRelationMapper.entityToModel(unitRuleRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitRuleRelation")));
            unitRuleRelationRepository.delete(unitRuleRelationMapper.modelToEntity(unitRuleRelation));
            return "UnitRuleRelation deleted";
        } catch (Exception e) {
            log.error("Couldn't delete unitRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your unitRuleRelation");
        }
    }
}
