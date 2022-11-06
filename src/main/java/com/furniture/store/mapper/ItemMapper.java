package com.furniture.store.mapper;

import com.furniture.store.dto.request.ItemRequest;
import com.furniture.store.dto.response.ItemResponse;
import com.furniture.store.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemResponse entityToDto(Item item);

    Item dtoToEntity(ItemRequest itemRequest);

    Item updateRequestToEntity(ItemRequest itemRequest, @MappingTarget Item item);
}
