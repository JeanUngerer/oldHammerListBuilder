package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.SpecialRuleDTO;
import com.oldhammer.fantasylistbuilder.entities.SpecialRuleEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.SpecialRule;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SpecialRuleMapper {
    SpecialRuleDTO modelToDto(SpecialRule model);
    List<SpecialRuleDTO> modelsToDtos(List<SpecialRule> model);
    SpecialRule dtoToModel(SpecialRuleDTO dto);
    List<SpecialRule> dtosToModels(List<SpecialRuleDTO> dtos);


    SpecialRuleEntity modelToEntity(SpecialRule model);
    List<SpecialRuleEntity> modelsToEntities(List<SpecialRule> models);

    SpecialRule entityToModel(SpecialRuleEntity entity);


    List<SpecialRule> entitiesToModel(List<SpecialRuleEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(SpecialRule model, @MappingTarget SpecialRuleEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(SpecialRuleDTO dto, @MappingTarget SpecialRule model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
