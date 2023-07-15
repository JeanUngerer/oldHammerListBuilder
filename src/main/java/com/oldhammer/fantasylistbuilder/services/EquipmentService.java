package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.EquipmentDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.EquipmentMapper;
import com.oldhammer.fantasylistbuilder.models.Equipment;
import com.oldhammer.fantasylistbuilder.repositories.EquipmentRepository;
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
public class EquipmentService {
    EquipmentRepository equipmentRepository;

    EquipmentMapper equipmentMapper;

    public List<Equipment> findAllEquipment() {
        try {
            log.info("findAllEquipment");
            List<Equipment> equipmentList = new ArrayList<Equipment>();
            equipmentRepository.findAll().forEach(ct -> equipmentList.add(equipmentMapper.entityToModel(ct)));
            return  equipmentList;
        } catch (Exception e) {
            log.error("We could not find all equipment: " + e.getMessage());
            throw new ExceptionHandler("We could not find your equipments");
        }
    }

    public Equipment findEquipmentById(Long id) {
        try {
            log.info("findEquipmentById - id: " + id.toString());
            Equipment equipment = equipmentMapper.entityToModel(equipmentRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your equipment")));
            return equipment;
        } catch (Exception e) {
            log.error("We could not find all equipment: " + e.getMessage());
            throw new ExceptionHandler("We could not find your equipment");
        }
    }

    public Equipment createEquipment(EquipmentDTO dto) {
        try {
            log.info("createEquipment");
            Equipment equipment = equipmentMapper.dtoToModel(dto);
            equipmentRepository.save(equipmentMapper.modelToEntity(equipment));
            return equipment;
        } catch (Exception e) {
            log.error("Couldn't equipment user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your equipment");
        }
    }
    public Equipment updateEquipment(EquipmentDTO dto) {
        try {
            log.info("updateEquipment - id: " + dto.getId().toString());
            Equipment equipment = equipmentMapper.entityToModel(equipmentRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your equipment")));
            equipmentMapper.updateFromDto(dto, equipment, new CycleAvoidingMappingContext());
            equipmentRepository.save(equipmentMapper.modelToEntity(equipment));
            return equipment;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your equipment");
        }
    }

    public String deleteEquipment(Long id) {
        try {
            log.info("deleteEquipment - id: " + id.toString());
            Equipment equipment = equipmentMapper.entityToModel(equipmentRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your equipment")));
            equipmentRepository.delete(equipmentMapper.modelToEntity(equipment));
            return "Equipment deleted";
        } catch (Exception e) {
            log.error("Couldn't delete equipment: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your equipment");
        }
    }
}
