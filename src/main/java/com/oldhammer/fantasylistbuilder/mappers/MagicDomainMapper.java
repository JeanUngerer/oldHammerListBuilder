package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.MagicDomainDTO;
import com.oldhammer.fantasylistbuilder.entities.MagicDomainEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.MagicDomain;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MagicDomainMapper {
    MagicDomainDTO modelToDto(MagicDomain model);
    List<MagicDomainDTO> modelsToDtos(List<MagicDomain> model);
    MagicDomain dtoToModel(MagicDomainDTO dto);
    List<MagicDomain> dtosToModels(List<MagicDomainDTO> dtos);


    MagicDomainEntity modelToEntity(MagicDomain model);
    List<MagicDomainEntity> modelsToEntities(List<MagicDomain> models);

    MagicDomain entityToModel(MagicDomainEntity entity);


    List<MagicDomain> entitiesToModel(List<MagicDomainEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(MagicDomain model, @MappingTarget MagicDomainEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(MagicDomainDTO dto, @MappingTarget MagicDomain model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
