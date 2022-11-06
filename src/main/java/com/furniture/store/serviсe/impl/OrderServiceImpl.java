package com.furniture.store.serviсe.impl;

import com.furniture.store.dto.request.OrderRequest;
import com.furniture.store.dto.response.OrderResponse;
import com.furniture.store.mapper.OrderMapper;
import com.furniture.store.model.Order;
import com.furniture.store.repository.OrderRepository;
import com.furniture.store.serviсe.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        return orderMapper.entityToDto(order);
    }

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        Order order = orderMapper.dtoToEntity(orderRequest);
        orderRepository.save(order);
        return orderMapper.entityToDto(order);
    }

    @Override
    public OrderResponse update(Long id, OrderRequest orderRequest) {
        Order oldOrder = orderRepository.findById(id)
                .orElseThrow();
        Order order = orderMapper.updateRequestToEntity(orderRequest, oldOrder);
        orderRepository.save(order);
        return orderMapper.entityToDto(order);
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();

        orderRepository.delete(order);
    }
}
