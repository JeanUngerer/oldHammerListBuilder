package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.UnitEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.entities.UnitEquipmentRelationEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.UnitEquipmentRelation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UnitEquipmentRelationMapper {
    UnitEquipmentRelationDTO modelToDto(UnitEquipmentRelation model);
    List<UnitEquipmentRelationDTO> modelsToDtos(List<UnitEquipmentRelation> model);
    UnitEquipmentRelation dtoToModel(UnitEquipmentRelationDTO dto);
    List<UnitEquipmentRelation> dtosToModels(List<UnitEquipmentRelationDTO> dtos);


    UnitEquipmentRelationEntity modelToEntity(UnitEquipmentRelation model);
    List<UnitEquipmentRelationEntity> modelsToEntities(List<UnitEquipmentRelation> models);

    UnitEquipmentRelation entityToModel(UnitEquipmentRelationEntity entity);


    List<UnitEquipmentRelation> entitiesToModel(List<UnitEquipmentRelationEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(UnitEquipmentRelation model, @MappingTarget UnitEquipmentRelationEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(UnitEquipmentRelationDTO dto, @MappingTarget UnitEquipmentRelation model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
