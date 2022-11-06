package com.furniture.store.mapper;

import com.furniture.store.dto.response.RoleResponse;
import com.furniture.store.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse entityToDto(Role role);
}
