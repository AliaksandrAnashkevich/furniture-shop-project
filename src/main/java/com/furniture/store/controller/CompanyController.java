package com.furniture.store.controller;

import com.furniture.store.dto.request.CompanyRequest;
import com.furniture.store.dto.response.CompanyResponse;
import com.furniture.store.serviсe.CompanyService;
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
@RequestMapping("/api/v1/companies")
@Tag(name = "Companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Get all Companies")
    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @Operation(summary = "Get Company by ID")
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.findById(companyId));
    }

    @Operation(summary = "Create new Company")
    @PostMapping
    public ResponseEntity<CompanyResponse> create(@RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok(companyService.create(companyRequest));
    }

    @Operation(summary = "Update Company by ID")
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> update(@PathVariable Long companyId,
                                                  @RequestBody CompanyRequest companyRequest) {
        return ResponseEntity.ok(companyService.update(companyId, companyRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Company by ID")
    @DeleteMapping("/{companyId}")
    public void delete(@PathVariable Long companyId) {
        companyService.delete(companyId);
    }
}
