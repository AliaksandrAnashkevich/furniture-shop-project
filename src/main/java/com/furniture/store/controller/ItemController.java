package com.furniture.store.controller;

import com.furniture.store.dto.request.ItemRequest;
import com.furniture.store.dto.response.ItemResponse;
import com.furniture.store.serviсe.ItemService;
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
@RequestMapping("/api/v1/items")
@Tag(name = "Items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "Get all Items")
    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @Operation(summary = "Get Item by ID")
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.findById(itemId));
    }

    @Operation(summary = "Create new Item")
    @PostMapping
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.create(itemRequest));
    }

    @Operation(summary = "Update Item by ID")
    @PutMapping("/{itemId}")
    public ResponseEntity<ItemResponse> update(@PathVariable Long itemId,
                                               @RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.update(itemId, itemRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Get Item by ID")
    @DeleteMapping("/{itemId}")
    public void delete(@PathVariable Long itemId) {
        itemService.delete(itemId);
    }
}