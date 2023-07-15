package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.UnitSelectionDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.UnitSelectionMapper;
import com.oldhammer.fantasylistbuilder.models.UnitSelection;
import com.oldhammer.fantasylistbuilder.repositories.UnitSelectionRepository;
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
public class UnitSelectionService {
    UnitSelectionRepository unitSelectionRepository;

    UnitSelectionMapper unitSelectionMapper;

    public List<UnitSelection> findAllUnitSelection() {
        try {
            log.info("findAllUnitSelection");
            List<UnitSelection> unitSelectionList = new ArrayList<UnitSelection>();
            unitSelectionRepository.findAll().forEach(ct -> unitSelectionList.add(unitSelectionMapper.entityToModel(ct)));
            return  unitSelectionList;
        } catch (Exception e) {
            log.error("We could not find all unitSelection: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitSelections");
        }
    }

    public UnitSelection findUnitSelectionById(Long id) {
        try {
            log.info("findUnitSelectionById - id: " + id.toString());
            UnitSelection unitSelection = unitSelectionMapper.entityToModel(unitSelectionRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your unitSelection")));
            return unitSelection;
        } catch (Exception e) {
            log.error("We could not find all unitSelection: " + e.getMessage());
            throw new ExceptionHandler("We could not find your unitSelection");
        }
    }

    public UnitSelection createUnitSelection(UnitSelectionDTO dto) {
        try {
            log.info("createUnitSelection");
            UnitSelection unitSelection = unitSelectionMapper.dtoToModel(dto);
            unitSelectionRepository.save(unitSelectionMapper.modelToEntity(unitSelection));
            return unitSelection;
        } catch (Exception e) {
            log.error("Couldn't unitSelection user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your unitSelection");
        }
    }
    public UnitSelection updateUnitSelection(UnitSelectionDTO dto) {
        try {
            log.info("updateUnitSelection - id: " + dto.getId().toString());
            UnitSelection unitSelection = unitSelectionMapper.entityToModel(unitSelectionRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitSelection")));
            unitSelectionMapper.updateFromDto(dto, unitSelection, new CycleAvoidingMappingContext());
            unitSelectionRepository.save(unitSelectionMapper.modelToEntity(unitSelection));
            return unitSelection;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your unitSelection");
        }
    }

    public String deleteUnitSelection(Long id) {
        try {
            log.info("deleteUnitSelection - id: " + id.toString());
            UnitSelection unitSelection = unitSelectionMapper.entityToModel(unitSelectionRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your unitSelection")));
            unitSelectionRepository.delete(unitSelectionMapper.modelToEntity(unitSelection));
            return "UnitSelection deleted";
        } catch (Exception e) {
            log.error("Couldn't delete unitSelection: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your unitSelection");
        }
    }
}
