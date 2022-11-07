package com.furniture.store.mapper;

import com.furniture.store.dto.request.ItemRequest;
import com.furniture.store.dto.response.ItemResponse;
import com.furniture.store.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "company.name", target = "company")
    ItemResponse entityToDto(Item item);

    @Mapping(target = "company", ignore = true)
    Item dtoToEntity(ItemRequest itemRequest);

    @Mapping(target = "company", ignore = true)
    Item updateRequestToEntity(ItemRequest itemRequest, @MappingTarget Item item);
}
