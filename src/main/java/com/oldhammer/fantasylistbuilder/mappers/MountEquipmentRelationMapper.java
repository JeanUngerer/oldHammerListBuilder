package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.MountEquipmentRelationDTO;
import com.oldhammer.fantasylistbuilder.entities.MountEquipmentRelationEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.MountEquipmentRelation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MountEquipmentRelationMapper {
    MountEquipmentRelationDTO modelToDto(MountEquipmentRelation model);
    List<MountEquipmentRelationDTO> modelsToDtos(List<MountEquipmentRelation> model);
    MountEquipmentRelation dtoToModel(MountEquipmentRelationDTO dto);
    List<MountEquipmentRelation> dtosToModels(List<MountEquipmentRelationDTO> dtos);


    MountEquipmentRelationEntity modelToEntity(MountEquipmentRelation model);
    List<MountEquipmentRelationEntity> modelsToEntities(List<MountEquipmentRelation> models);

    MountEquipmentRelation entityToModel(MountEquipmentRelationEntity entity);


    List<MountEquipmentRelation> entitiesToModel(List<MountEquipmentRelationEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(MountEquipmentRelation model, @MappingTarget MountEquipmentRelationEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(MountEquipmentRelationDTO dto, @MappingTarget MountEquipmentRelation model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
