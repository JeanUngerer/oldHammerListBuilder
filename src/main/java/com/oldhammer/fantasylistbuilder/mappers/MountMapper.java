package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.MountDTO;
import com.oldhammer.fantasylistbuilder.entities.MountEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.Mount;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MountMapper {
    MountDTO modelToDto(Mount model);
    List<MountDTO> modelsToDtos(List<Mount> model);
    Mount dtoToModel(MountDTO dto);
    List<Mount> dtosToModels(List<MountDTO> dtos);


    MountEntity modelToEntity(Mount model);
    List<MountEntity> modelsToEntities(List<Mount> models);

    Mount entityToModel(MountEntity entity);


    List<Mount> entitiesToModel(List<MountEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(Mount model, @MappingTarget MountEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(MountDTO dto, @MappingTarget Mount model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
