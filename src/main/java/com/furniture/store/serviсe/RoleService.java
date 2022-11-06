package com.furniture.store.serviсe;

import com.furniture.store.dto.response.RoleResponse;
import com.furniture.store.model.Role;

import java.util.List;

public interface RoleService {

    RoleResponse findById(Long id);

    List<RoleResponse> findAll();
}
