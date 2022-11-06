package com.furniture.store.serviсe.impl;

import com.furniture.store.dto.response.RoleResponse;
import com.furniture.store.mapper.RoleMapper;
import com.furniture.store.model.Role;
import com.furniture.store.repository.RoleRepository;
import com.furniture.store.serviсe.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow();

        return roleMapper.entityToDto(role);
    }
}
