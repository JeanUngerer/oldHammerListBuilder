package com.oldhammer.fantasylistbuilder.mappers;

import com.oldhammer.fantasylistbuilder.DTOs.AllBooksDTO;
import com.oldhammer.fantasylistbuilder.entities.AllBooksEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.AllBooks;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AllBooksMapper {

    AllBooksDTO modelToDto(AllBooks model);
    List<AllBooksDTO> modelsToDtos(List<AllBooks> model);
    AllBooks dtoToModel(AllBooksDTO dto);
    List<AllBooks> dtosToModels(List<AllBooksDTO> dtos);


    AllBooksEntity modelToEntity(AllBooks model);
    List<AllBooksEntity> modelsToEntities(List<AllBooks> models);

    AllBooks entityToModel(AllBooksEntity entity);


    List<AllBooks> entitiesToModel(List<AllBooksEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromModel(AllBooks model, @MappingTarget AllBooksEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateFromDto(AllBooksDTO dto, @MappingTarget AllBooks model, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
