package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitSelectionDTO;
import com.oldhammer.fantasylistbuilder.entities.UnitSelectionEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.UnitSelection;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UnitSelectionMapper {
    UnitSelectionDTO modelToDto(UnitSelection model);
    List<UnitSelectionDTO> modelsToDtos(List<UnitSelection> model);
    UnitSelection dtoToModel(UnitSelectionDTO dto);
    List<UnitSelection> dtosToModels(List<UnitSelectionDTO> dtos);


    UnitSelectionEntity modelToEntity(UnitSelection model);
    List<UnitSelectionEntity> modelsToEntities(List<UnitSelection> models);

    UnitSelection entityToModel(UnitSelectionEntity entity);


    List<UnitSelection> entitiesToModel(List<UnitSelectionEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(UnitSelection model, @MappingTarget UnitSelectionEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(UnitSelectionDTO dto, @MappingTarget UnitSelection model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
