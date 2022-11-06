package com.furniture.store.mapper;

import com.furniture.store.dto.request.OrderRequest;
import com.furniture.store.dto.response.OrderResponse;
import com.furniture.store.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse entityToDto(Order order);

    Order dtoToEntity(OrderRequest orderRequest);

    Order updateRequestToEntity(OrderRequest orderRequest, @MappingTarget Order order);

}
