package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.ArmyListDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.ArmyListMapper;
import com.oldhammer.fantasylistbuilder.models.ArmyList;
import com.oldhammer.fantasylistbuilder.repositories.ArmyListRepository;
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
public class ArmyListService {
    ArmyListRepository armyListRepository;

    ArmyListMapper armyListMapper;

    public List<ArmyList> findAllArmyList() {
        try {
            log.info("findAllArmyList");
            List<ArmyList> armyListList = new ArrayList<ArmyList>();
            armyListRepository.findAll().forEach(ct -> armyListList.add(armyListMapper.entityToModel(ct)));
            return  armyListList;
        } catch (Exception e) {
            log.error("We could not find all armyList: " + e.getMessage());
            throw new ExceptionHandler("We could not find your armyLists");
        }
    }

    public ArmyList findArmyListById(Long id) {
        try {
            log.info("findArmyListById - id: " + id.toString());
            ArmyList armyList = armyListMapper.entityToModel(armyListRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your armyList")));
            return armyList;
        } catch (Exception e) {
            log.error("We could not find all armyList: " + e.getMessage());
            throw new ExceptionHandler("We could not find your armyList");
        }
    }

    public ArmyList createArmyList(ArmyListDTO dto) {
        try {
            log.info("createArmyList");
            ArmyList armyList = armyListMapper.dtoToModel(dto);
            armyListRepository.save(armyListMapper.modelToEntity(armyList));
            return armyList;
        } catch (Exception e) {
            log.error("Couldn't armyList user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your armyList");
        }
    }
    public ArmyList updateArmyList(ArmyListDTO dto) {
        try {
            log.info("updateArmyList - id: " + dto.getId().toString());
            ArmyList armyList = armyListMapper.entityToModel(armyListRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your armyList")));
            armyListMapper.updateFromDto(dto, armyList, new CycleAvoidingMappingContext());
            armyListRepository.save(armyListMapper.modelToEntity(armyList));
            return armyList;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your armyList");
        }
    }

    public String deleteArmyList(Long id) {
        try {
            log.info("deleteArmyList - id: " + id.toString());
            ArmyList armyList = armyListMapper.entityToModel(armyListRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your armyList")));
            armyListRepository.delete(armyListMapper.modelToEntity(armyList));
            return "ArmyList deleted";
        } catch (Exception e) {
            log.error("Couldn't delete armyList: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your armyList");
        }
    }
}
