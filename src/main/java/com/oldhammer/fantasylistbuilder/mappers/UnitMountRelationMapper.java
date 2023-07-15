package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitMountRelationDTO;
import com.oldhammer.fantasylistbuilder.entities.UnitMountRelationEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.UnitMountRelation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UnitMountRelationMapper {
    UnitMountRelationDTO modelToDto(UnitMountRelation model);
    List<UnitMountRelationDTO> modelsToDtos(List<UnitMountRelation> model);
    UnitMountRelation dtoToModel(UnitMountRelationDTO dto);
    List<UnitMountRelation> dtosToModels(List<UnitMountRelationDTO> dtos);


    UnitMountRelationEntity modelToEntity(UnitMountRelation model);
    List<UnitMountRelationEntity> modelsToEntities(List<UnitMountRelation> models);

    UnitMountRelation entityToModel(UnitMountRelationEntity entity);


    List<UnitMountRelation> entitiesToModel(List<UnitMountRelationEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(UnitMountRelation model, @MappingTarget UnitMountRelationEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(UnitMountRelationDTO dto, @MappingTarget UnitMountRelation model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
