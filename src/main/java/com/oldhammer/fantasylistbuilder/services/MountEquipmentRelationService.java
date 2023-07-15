package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.MountEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.MountEquipmentRelationMapper;
import com.oldhammer.fantasylistbuilder.models.MountEquipmentRelation;
import com.oldhammer.fantasylistbuilder.repositories.MountEquipmentRelationRepository;
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
public class MountEquipmentRelationService {
    MountEquipmentRelationRepository mountEquipmentRelationRepository;

    MountEquipmentRelationMapper mountEquipmentRelationMapper;

    public List<MountEquipmentRelation> findAllMountEquipmentRelation() {
        try {
            log.info("findAllMountEquipmentRelation");
            List<MountEquipmentRelation> mountEquipmentRelationList = new ArrayList<MountEquipmentRelation>();
            mountEquipmentRelationRepository.findAll().forEach(ct -> mountEquipmentRelationList.add(mountEquipmentRelationMapper.entityToModel(ct)));
            return  mountEquipmentRelationList;
        } catch (Exception e) {
            log.error("We could not find all mountEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mountEquipmentRelations");
        }
    }

    public MountEquipmentRelation findMountEquipmentRelationById(Long id) {
        try {
            log.info("findMountEquipmentRelationById - id: " + id.toString());
            MountEquipmentRelation mountEquipmentRelation = mountEquipmentRelationMapper.entityToModel(mountEquipmentRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your mountEquipmentRelation")));
            return mountEquipmentRelation;
        } catch (Exception e) {
            log.error("We could not find all mountEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mountEquipmentRelation");
        }
    }

    public MountEquipmentRelation createMountEquipmentRelation(MountEquipmentRelationDTO dto) {
        try {
            log.info("createMountEquipmentRelation");
            MountEquipmentRelation mountEquipmentRelation = mountEquipmentRelationMapper.dtoToModel(dto);
            mountEquipmentRelationRepository.save(mountEquipmentRelationMapper.modelToEntity(mountEquipmentRelation));
            return mountEquipmentRelation;
        } catch (Exception e) {
            log.error("Couldn't mountEquipmentRelation user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your mountEquipmentRelation");
        }
    }
    public MountEquipmentRelation updateMountEquipmentRelation(MountEquipmentRelationDTO dto) {
        try {
            log.info("updateMountEquipmentRelation - id: " + dto.getId().toString());
            MountEquipmentRelation mountEquipmentRelation = mountEquipmentRelationMapper.entityToModel(mountEquipmentRelationRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mountEquipmentRelation")));
            mountEquipmentRelationMapper.updateFromDto(dto, mountEquipmentRelation, new CycleAvoidingMappingContext());
            mountEquipmentRelationRepository.save(mountEquipmentRelationMapper.modelToEntity(mountEquipmentRelation));
            return mountEquipmentRelation;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your mountEquipmentRelation");
        }
    }

    public String deleteMountEquipmentRelation(Long id) {
        try {
            log.info("deleteMountEquipmentRelation - id: " + id.toString());
            MountEquipmentRelation mountEquipmentRelation = mountEquipmentRelationMapper.entityToModel(mountEquipmentRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mountEquipmentRelation")));
            mountEquipmentRelationRepository.delete(mountEquipmentRelationMapper.modelToEntity(mountEquipmentRelation));
            return "MountEquipmentRelation deleted";
        } catch (Exception e) {
            log.error("Couldn't delete mountEquipmentRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your mountEquipmentRelation");
        }
    }
}
