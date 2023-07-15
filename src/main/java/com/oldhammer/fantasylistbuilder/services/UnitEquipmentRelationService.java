package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.UnitEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.UnitEquipmentRelationMapper;
import com.oldhammer.fantasylistbuilder.models.UnitEquipmentRelation;
import com.oldhammer.fantasylistbuilder.repositories.UnitEquipmentRelationRepository;
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
public class UnitEquipmentRelationService {
    UnitEquipmentRelationRepository unitEquipmentRelationRepository;

    UnitEquipmentRelationMapper unitEquipmentRelationMapper;

    public List<UnitEquipmentRelation> findAllUnitEquipmentRelation() {
        try {
            log.info("findAllUnitEquipmentRelation");
            List<UnitEquipmentRelation> unitEquipmentRelationList = new ArrayList<UnitEquipmentRelation>();
            unitEquipmentRelationRepository.findAll().forEach(ct -> unitEquipmentRelationList.add(unitEquipmentRelationMapper.entityToModel(ct)));
            return  unitEquipmentRelationList;
        } catch (Exception e) {
            log.error("We could not find all unitEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitEquipmentRelations");
        }
    }

    public UnitEquipmentRelation findUnitEquipmentRelationById(Long id) {
        try {
            log.info("findUnitEquipmentRelationById - id: " + id.toString());
            UnitEquipmentRelation unitEquipmentRelation = unitEquipmentRelationMapper.entityToModel(unitEquipmentRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your unitEquipmentRelation")));
            return unitEquipmentRelation;
        } catch (Exception e) {
            log.error("We could not find all unitEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitEquipmentRelation");
        }
    }

    public UnitEquipmentRelation createUnitEquipmentRelation(UnitEquipmentRelationDTO dto) {
        try {
            log.info("createUnitEquipmentRelation");
            UnitEquipmentRelation unitEquipmentRelation = unitEquipmentRelationMapper.dtoToModel(dto);
            unitEquipmentRelationRepository.save(unitEquipmentRelationMapper.modelToEntity(unitEquipmentRelation));
            return unitEquipmentRelation;
        } catch (Exception e) {
            log.error("Couldn't unitEquipmentRelation user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your unitEquipmentRelation");
        }
    }
    public UnitEquipmentRelation updateUnitEquipmentRelation(UnitEquipmentRelationDTO dto) {
        try {
            log.info("updateUnitEquipmentRelation - id: " + dto.getId().toString());
            UnitEquipmentRelation unitEquipmentRelation = unitEquipmentRelationMapper.entityToModel(unitEquipmentRelationRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitEquipmentRelation")));
            unitEquipmentRelationMapper.updateFromDto(dto, unitEquipmentRelation, new CycleAvoidingMappingContext());
            unitEquipmentRelationRepository.save(unitEquipmentRelationMapper.modelToEntity(unitEquipmentRelation));
            return unitEquipmentRelation;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your unitEquipmentRelation");
        }
    }

    public String deleteUnitEquipmentRelation(Long id) {
        try {
            log.info("deleteUnitEquipmentRelation - id: " + id.toString());
            UnitEquipmentRelation unitEquipmentRelation = unitEquipmentRelationMapper.entityToModel(unitEquipmentRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitEquipmentRelation")));
            unitEquipmentRelationRepository.delete(unitEquipmentRelationMapper.modelToEntity(unitEquipmentRelation));
            return "UnitEquipmentRelation deleted";
        } catch (Exception e) {
            log.error("Couldn't delete unitEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your unitEquipmentRelation");
        }
    }
}
