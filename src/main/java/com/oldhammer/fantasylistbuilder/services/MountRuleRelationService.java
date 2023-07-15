package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.MountRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.MountRuleRelationMapper;
import com.oldhammer.fantasylistbuilder.models.MountRuleRelation;
import com.oldhammer.fantasylistbuilder.repositories.MountRuleRelationRepository;
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
public class MountRuleRelationService {
    MountRuleRelationRepository mountRuleRelationRepository;

    MountRuleRelationMapper mountRuleRelationMapper;

    public List<MountRuleRelation> findAllMountRuleRelation() {
        try {
            log.info("findAllMountRuleRelation");
            List<MountRuleRelation> mountRuleRelationList = new ArrayList<MountRuleRelation>();
            mountRuleRelationRepository.findAll().forEach(ct -> mountRuleRelationList.add(mountRuleRelationMapper.entityToModel(ct)));
            return  mountRuleRelationList;
        } catch (Exception e) {
            log.error("We could not find all mountRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mountRuleRelations");
        }
    }

    public MountRuleRelation findMountRuleRelationById(Long id) {
        try {
            log.info("findMountRuleRelationById - id: " + id.toString());
            MountRuleRelation mountRuleRelation = mountRuleRelationMapper.entityToModel(mountRuleRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your mountRuleRelation")));
            return mountRuleRelation;
        } catch (Exception e) {
            log.error("We could not find all mountRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not find your mountRuleRelation");
        }
    }

    public MountRuleRelation createMountRuleRelation(MountRuleRelationDTO dto) {
        try {
            log.info("createMountRuleRelation");
            MountRuleRelation mountRuleRelation = mountRuleRelationMapper.dtoToModel(dto);
            mountRuleRelationRepository.save(mountRuleRelationMapper.modelToEntity(mountRuleRelation));
            return mountRuleRelation;
        } catch (Exception e) {
            log.error("Couldn't mountRuleRelation user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your mountRuleRelation");
        }
    }
    public MountRuleRelation updateMountRuleRelation(MountRuleRelationDTO dto) {
        try {
            log.info("updateMountRuleRelation - id: " + dto.getId().toString());
            MountRuleRelation mountRuleRelation = mountRuleRelationMapper.entityToModel(mountRuleRelationRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mountRuleRelation")));
            mountRuleRelationMapper.updateFromDto(dto, mountRuleRelation, new CycleAvoidingMappingContext());
            mountRuleRelationRepository.save(mountRuleRelationMapper.modelToEntity(mountRuleRelation));
            return mountRuleRelation;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your mountRuleRelation");
        }
    }

    public String deleteMountRuleRelation(Long id) {
        try {
            log.info("deleteMountRuleRelation - id: " + id.toString());
            MountRuleRelation mountRuleRelation = mountRuleRelationMapper.entityToModel(mountRuleRelationRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your mountRuleRelation")));
            mountRuleRelationRepository.delete(mountRuleRelationMapper.modelToEntity(mountRuleRelation));
            return "MountRuleRelation deleted";
        } catch (Exception e) {
            log.error("Couldn't delete mountRuleRelation: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your mountRuleRelation");
        }
    }
}
