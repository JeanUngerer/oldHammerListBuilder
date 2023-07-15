package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.UnitDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.UnitMapper;
import com.oldhammer.fantasylistbuilder.models.Unit;
import com.oldhammer.fantasylistbuilder.repositories.UnitRepository;
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
public class UnitService {
    UnitRepository unitRepository;

    UnitMapper unitMapper;

    public List<Unit> findAllUnit() {
        try {
            log.info("findAllUnit");
            List<Unit> unitList = new ArrayList<Unit>();
            unitRepository.findAll().forEach(ct -> unitList.add(unitMapper.entityToModel(ct)));
            return  unitList;
        } catch (Exception e) {
            log.error("We could not find all unit: " + e.getMessage());
            throw new ExceptionHandler("We could not find your units");
        }
    }

    public Unit findUnitById(Long id) {
        try {
            log.info("findUnitById - id: " + id.toString());
            Unit unit = unitMapper.entityToModel(unitRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your unit")));
            return unit;
        } catch (Exception e) {
            log.error("We could not find all unit: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unit");
        }
    }

    public Unit createUnit(UnitDTO dto) {
        try {
            log.info("createUnit");
            Unit unit = unitMapper.dtoToModel(dto);
            unitRepository.save(unitMapper.modelToEntity(unit));
            return unit;
        } catch (Exception e) {
            log.error("Couldn't unit user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your unit");
        }
    }
    public Unit updateUnit(UnitDTO dto) {
        try {
            log.info("updateUnit - id: " + dto.getId().toString());
            Unit unit = unitMapper.entityToModel(unitRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unit")));
            unitMapper.updateFromDto(dto, unit, new CycleAvoidingMappingContext());
            unitRepository.save(unitMapper.modelToEntity(unit));
            return unit;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your unit");
        }
    }

    public String deleteUnit(Long id) {
        try {
            log.info("deleteUnit - id: " + id.toString());
            Unit unit = unitMapper.entityToModel(unitRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unit")));
            unitRepository.delete(unitMapper.modelToEntity(unit));
            return "Unit deleted";
        } catch (Exception e) {
            log.error("Couldn't delete unit: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your unit");
        }
    }
}
