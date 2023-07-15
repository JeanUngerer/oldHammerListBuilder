package com.oldhammer.fantasylistbuilder.mappers;


import com.oldhammer.fantasylistbuilder.DTOs.UserDTO;
import com.oldhammer.fantasylistbuilder.entities.UserEntity;
import com.oldhammer.fantasylistbuilder.helpers.CycleAvoidingMappingContext;
import com.oldhammer.fantasylistbuilder.models.user.MyUser;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserDTO modelToDto(MyUser myUser);
    List<UserDTO> modelsToDtos(List<MyUser> myUser);
    MyUser dtoToModel(UserDTO dto);
    List<MyUser> dtosToModels(List<UserDTO> dtos);


    UserEntity modelToEntity(MyUser myUser);
    List<UserEntity> modelsToEntities(List<MyUser> myUsers);

    MyUser entityToModel(UserEntity entity);

    List<MyUser> entitiesToModel(List<UserEntity> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromModel(MyUser model, @MappingTarget UserEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    void updateUserFromDto(UserDTO dto, @MappingTarget MyUser myUser, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
