package com.furniture.store.mapper;

import com.furniture.store.dto.request.UserRequest;
import com.furniture.store.dto.response.UserResponse;
import com.furniture.store.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse entityToDto(User user);

    User dtoToEntity(UserRequest userRequest);

    User updateRequestToEntity(UserRequest userRequest, @MappingTarget User user);
}
