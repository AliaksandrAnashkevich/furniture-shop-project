package com.furniture.store.controller;

import com.furniture.store.dto.request.OrderRequest;
import com.furniture.store.dto.response.OrderResponse;
import com.furniture.store.serviсe.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Get all Orders")
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @Operation(summary = "Get Order by ID")
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @Operation(summary = "Create new Order")
    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.create(orderRequest));
    }

    @Operation(summary = "Update Order by ID")
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> update(@PathVariable Long orderId,
                                               @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.update(orderId, orderRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Get Order by ID")
    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
    }
}
