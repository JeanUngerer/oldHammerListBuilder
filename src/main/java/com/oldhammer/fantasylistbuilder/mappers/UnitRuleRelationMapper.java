package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.entities.UnitRuleRelationEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.UnitRuleRelation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UnitRuleRelationMapper {
    UnitRuleRelationDTO modelToDto(UnitRuleRelation model);
    List<UnitRuleRelationDTO> modelsToDtos(List<UnitRuleRelation> model);
    UnitRuleRelation dtoToModel(UnitRuleRelationDTO dto);
    List<UnitRuleRelation> dtosToModels(List<UnitRuleRelationDTO> dtos);


    UnitRuleRelationEntity modelToEntity(UnitRuleRelation model);
    List<UnitRuleRelationEntity> modelsToEntities(List<UnitRuleRelation> models);

    UnitRuleRelation entityToModel(UnitRuleRelationEntity entity);


    List<UnitRuleRelation> entitiesToModel(List<UnitRuleRelationEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(UnitRuleRelation model, @MappingTarget UnitRuleRelationEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(UnitRuleRelationDTO dto, @MappingTarget UnitRuleRelation model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
