package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.MountRuleRelationDTO;
import com.oldhammer.fantasylistbuilder.entities.MountRuleRelationEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.MountRuleRelation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MountRuleRelationMapper {
    MountRuleRelationDTO modelToDto(MountRuleRelation model);
    List<MountRuleRelationDTO> modelsToDtos(List<MountRuleRelation> model);
    MountRuleRelation dtoToModel(MountRuleRelationDTO dto);
    List<MountRuleRelation> dtosToModels(List<MountRuleRelationDTO> dtos);


    MountRuleRelationEntity modelToEntity(MountRuleRelation model);
    List<MountRuleRelationEntity> modelsToEntities(List<MountRuleRelation> models);

    MountRuleRelation entityToModel(MountRuleRelationEntity entity);


    List<MountRuleRelation> entitiesToModel(List<MountRuleRelationEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(MountRuleRelation model, @MappingTarget MountRuleRelationEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(MountRuleRelationDTO dto, @MappingTarget MountRuleRelation model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
