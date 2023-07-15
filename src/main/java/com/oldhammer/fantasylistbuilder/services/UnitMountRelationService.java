package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.UnitMountRelationDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.UnitMountRelationMapper;
import com.oldhammer.fantasylistbuilder.models.UnitMountRelation;
import com.oldhammer.fantasylistbuilder.repositories.UnitMountRelationRepository;
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
public class UnitMountRelationService {
    UnitMountRelationRepository unitMountRelationRepository;

    UnitMountRelationMapper unitMountRelationMapper;

    public List<UnitMountRelation> findAllUnitMountRelation() {
        try {
            log.info("findAllUnitMountRelation");
            List<UnitMountRelation> unitMountRelationList = new ArrayList<UnitMountRelation>();
            unitMountRelationRepository.findAll().forEach(ct -> unitMountRelationList.add(unitMountRelationMapper.entityToModel(ct)));
            return  unitMountRelationList;
        } catch (Exception e) {
            log.error("We could not find all unitMountRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitMountRelations");
        }
    }

    public UnitMountRelation findUnitMountRelationById(Long id) {
        try {
            log.info("findUnitMountRelationById - id: " + id.toString());
            UnitMountRelation unitMountRelation = unitMountRelationMapper.entityToModel(unitMountRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your unitMountRelation")));
            return unitMountRelation;
        } catch (Exception e) {
            log.error("We could not find all unitMountRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitMountRelation");
        }
    }

    public UnitMountRelation createUnitMountRelation(UnitMountRelationDTO dto) {
        try {
            log.info("createUnitMountRelation");
            UnitMountRelation unitMountRelation = unitMountRelationMapper.dtoToModel(dto);
            unitMountRelationRepository.save(unitMountRelationMapper.modelToEntity(unitMountRelation));
            return unitMountRelation;
        } catch (Exception e) {
            log.error("Couldn't unitMountRelation user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your unitMountRelation");
        }
    }
    public UnitMountRelation updateUnitMountRelation(UnitMountRelationDTO dto) {
        try {
            log.info("updateUnitMountRelation - id: " + dto.getId().toString());
            UnitMountRelation unitMountRelation = unitMountRelationMapper.entityToModel(unitMountRelationRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitMountRelation")));
            unitMountRelationMapper.updateFromDto(dto, unitMountRelation, new CycleAvoidingMappingContext());
            unitMountRelationRepository.save(unitMountRelationMapper.modelToEntity(unitMountRelation));
            return unitMountRelation;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your unitMountRelation");
        }
    }

    public String deleteUnitMountRelation(Long id) {
        try {
            log.info("deleteUnitMountRelation - id: " + id.toString());
            UnitMountRelation unitMountRelation = unitMountRelationMapper.entityToModel(unitMountRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitMountRelation")));
            unitMountRelationRepository.delete(unitMountRelationMapper.modelToEntity(unitMountRelation));
            return "UnitMountRelation deleted";
        } catch (Exception e) {
            log.error("Couldn't delete unitMountRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your unitMountRelation");
        }
    }
}
