package com.furniture.store.controller;

import com.furniture.store.dto.response.RoleResponse;
import com.furniture.store.serviсe.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@Tag(name = "Roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "Get all Roles")
    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @Operation(summary = "Get Role by ID")
    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Long roleId) {
        return ResponseEntity.ok(roleService.findById(roleId));
    }
}
