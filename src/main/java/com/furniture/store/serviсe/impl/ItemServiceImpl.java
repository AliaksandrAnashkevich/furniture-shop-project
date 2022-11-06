package com.furniture.store.serviсe.impl;

import com.furniture.store.dto.request.ItemRequest;
import com.furniture.store.dto.response.ItemResponse;
import com.furniture.store.mapper.ItemMapper;
import com.furniture.store.model.Item;
import com.furniture.store.repository.ItemRepository;
import com.furniture.store.serviсe.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemResponse> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponse findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow();

        return itemMapper.entityToDto(item);
    }

    @Override
    public ItemResponse create(ItemRequest itemRequest) {
        Item item = itemMapper.dtoToEntity(itemRequest);
        itemRepository.save(item);
        return itemMapper.entityToDto(item);
    }

    @Override
    public ItemResponse update(Long id, ItemRequest itemRequest) {
        Item oldItem = itemRepository.findById(id)
                .orElseThrow();
        Item item = itemMapper.updateRequestToEntity(itemRequest, oldItem);
        itemRepository.save(item);
        return itemMapper.entityToDto(item);
    }

    @Override
    public void delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow();

        itemRepository.delete(item);
    }
}
