package com.furniture.store.serviсe;

import com.furniture.store.dto.request.OrderRequest;
import com.furniture.store.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> findAll();

    OrderResponse findById(Long id);

    OrderResponse create(OrderRequest orderRequest);

    OrderResponse update(Long id, OrderRequest orderRequest);

    void delete(Long id);
}
