package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.ArmyListDTO;
import com.oldhammer.fantasylistbuilder.entities.ArmyListEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.ArmyList;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ArmyListMapper {
    ArmyListDTO modelToDto(ArmyList model);
    List<ArmyListDTO> modelsToDtos(List<ArmyList> model);
    ArmyList dtoToModel(ArmyListDTO dto);
    List<ArmyList> dtosToModels(List<ArmyListDTO> dtos);


    ArmyListEntity modelToEntity(ArmyList model);
    List<ArmyListEntity> modelsToEntities(List<ArmyList> models);

    ArmyList entityToModel(ArmyListEntity entity);


    List<ArmyList> entitiesToModel(List<ArmyListEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(ArmyList model, @MappingTarget ArmyListEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(ArmyListDTO dto, @MappingTarget ArmyList model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
