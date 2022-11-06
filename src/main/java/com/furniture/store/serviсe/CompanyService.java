package com.furniture.store.serviсe;

import com.furniture.store.dto.request.CompanyRequest;
import com.furniture.store.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> findAll();

    CompanyResponse findById(Long id);

    CompanyResponse create(CompanyRequest companyRequest);

    CompanyResponse update(Long id, CompanyRequest companyRequest);

    void delete(Long id);
}
