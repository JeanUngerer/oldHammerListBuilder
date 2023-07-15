package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.EquipmentDTO;
import com.oldhammer.fantasylistbuilder.entities.EquipmentEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.Equipment;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EquipmentMapper {
    EquipmentDTO modelToDto(Equipment model);
    List<EquipmentDTO> modelsToDtos(List<Equipment> model);
    Equipment dtoToModel(EquipmentDTO dto);
    List<Equipment> dtosToModels(List<EquipmentDTO> dtos);


    EquipmentEntity modelToEntity(Equipment model);
    List<EquipmentEntity> modelsToEntities(List<Equipment> models);

    Equipment entityToModel(EquipmentEntity entity);


    List<Equipment> entitiesToModel(List<EquipmentEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(Equipment model, @MappingTarget EquipmentEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(EquipmentDTO dto, @MappingTarget Equipment model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
