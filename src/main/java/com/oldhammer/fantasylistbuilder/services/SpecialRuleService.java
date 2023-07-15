package com.oldhammer.fantasylistbuilder.services;

import com.oldhammer.fantasylistbuilder.DTOs.SpecialRuleDTO;
import com.oldhammer.fantasylistbuilder.exception.ExceptionHandler;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.mappers.SpecialRuleMapper;
import com.oldhammer.fantasylistbuilder.models.SpecialRule;
import com.oldhammer.fantasylistbuilder.repositories.SpecialRuleRepository;
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
public class SpecialRuleService {
    SpecialRuleRepository specialRuleRepository;

    SpecialRuleMapper specialRuleMapper;

    public List<SpecialRule> findAllSpecialRule() {
        try {
            log.info("findAllSpecialRule");
            List<SpecialRule> specialRuleList = new ArrayList<SpecialRule>();
            specialRuleRepository.findAll().forEach(ct -> specialRuleList.add(specialRuleMapper.entityToModel(ct)));
            return  specialRuleList;
        } catch (Exception e) {
            log.error("We could not find all specialRule: " + e.getMessage());
            throw new ExceptionHandler("We could not find your specialRules");
        }
    }

    public SpecialRule findSpecialRuleById(Long id) {
        try {
            log.info("findSpecialRuleById - id: " + id.toString());
            SpecialRule specialRule = specialRuleMapper.entityToModel(specialRuleRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We didn't find your specialRule")));
            return specialRule;
        } catch (Exception e) {
            log.error("We could not find all specialRule: " + e.getMessage());
            throw new ExceptionHandler("We could not find your specialRule");
        }
    }

    public SpecialRule createSpecialRule(SpecialRuleDTO dto) {
        try {
            log.info("createSpecialRule");
            SpecialRule specialRule = specialRuleMapper.dtoToModel(dto);
            specialRuleRepository.save(specialRuleMapper.modelToEntity(specialRule));
            return specialRule;
        } catch (Exception e) {
            log.error("Couldn't specialRule user: " + e.getMessage());
            throw new ExceptionHandler("We could not create your specialRule");
        }
    }
    public SpecialRule updateSpecialRule(SpecialRuleDTO dto) {
        try {
            log.info("updateSpecialRule - id: " + dto.getId().toString());
            SpecialRule specialRule = specialRuleMapper.entityToModel(specialRuleRepository.findById(dto.getId()).orElseThrow(()
                    -> new ExceptionHandler("We could not find your specialRule")));
            specialRuleMapper.updateFromDto(dto, specialRule, new CycleAvoidingMappingContext());
            specialRuleRepository.save(specialRuleMapper.modelToEntity(specialRule));
            return specialRule;
        } catch (Exception e) {
            log.error("Couldn't update user: " + e.getMessage());
            throw new ExceptionHandler("We could not update your specialRule");
        }
    }

    public String deleteSpecialRule(Long id) {
        try {
            log.info("deleteSpecialRule - id: " + id.toString());
            SpecialRule specialRule = specialRuleMapper.entityToModel(specialRuleRepository.findById(id).orElseThrow(()
                    -> new ExceptionHandler("We could not find your specialRule")));
            specialRuleRepository.delete(specialRuleMapper.modelToEntity(specialRule));
            return "SpecialRule deleted";
        } catch (Exception e) {
            log.error("Couldn't delete specialRule: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your specialRule");
        }
    }
}
