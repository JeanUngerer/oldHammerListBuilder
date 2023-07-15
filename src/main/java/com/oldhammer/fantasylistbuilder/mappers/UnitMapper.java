package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitDTO;
import com.oldhammer.fantasylistbuilder.entities.UnitEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.Unit;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UnitMapper {
    UnitDTO modelToDto(Unit model);
    List<UnitDTO> modelsToDtos(List<Unit> model);
    Unit dtoToModel(UnitDTO dto);
    List<Unit> dtosToModels(List<UnitDTO> dtos);


    UnitEntity modelToEntity(Unit model);
    List<UnitEntity> modelsToEntities(List<Unit> models);

    Unit entityToModel(UnitEntity entity);


    List<Unit> entitiesToModel(List<UnitEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(Unit model, @MappingTarget UnitEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(UnitDTO dto, @MappingTarget Unit model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
