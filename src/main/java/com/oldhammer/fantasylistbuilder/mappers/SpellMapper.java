package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.SpellDTO;
import com.oldhammer.fantasylistbuilder.entities.SpellEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.Spell;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SpellMapper {
    SpellDTO modelToDto(Spell model);
    List<SpellDTO> modelsToDtos(List<Spell> model);
    Spell dtoToModel(SpellDTO dto);
    List<Spell> dtosToModels(List<SpellDTO> dtos);


    SpellEntity modelToEntity(Spell model);
    List<SpellEntity> modelsToEntities(List<Spell> models);

    Spell entityToModel(SpellEntity entity);


    List<Spell> entitiesToModel(List<SpellEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(Spell model, @MappingTarget SpellEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(SpellDTO dto, @MappingTarget Spell model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
