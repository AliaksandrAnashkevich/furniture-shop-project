package com.furniture.store.serviсe;

import com.furniture.store.dto.request.ItemRequest;
import com.furniture.store.dto.response.ItemResponse;

import java.util.List;

public interface ItemService {

    List<ItemResponse> findAll();

    ItemResponse findById(Long id);

    ItemResponse create(ItemRequest itemRequest);

    ItemResponse update(Long id, ItemRequest itemRequest);

    void delete(Long id);
}
