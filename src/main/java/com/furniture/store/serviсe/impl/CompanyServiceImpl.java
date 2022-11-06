package com.furniture.store.serviсe.impl;

import com.furniture.store.dto.request.CompanyRequest;
import com.furniture.store.dto.response.CompanyResponse;
import com.furniture.store.mapper.CompanyMapper;
import com.furniture.store.model.Company;
import com.furniture.store.repository.CompanyRepository;
import com.furniture.store.serviсe.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponse> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponse findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow();

        return companyMapper.entityToDto(company);
    }

    @Override
    public CompanyResponse create(CompanyRequest companyRequest) {

        Company company = companyMapper.dtoToEntity(companyRequest);
        companyRepository.save(company);
        return companyMapper.entityToDto(company);
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {

        Company oldCompany = companyRepository.findById(id)
                .orElseThrow();
        Company company = companyMapper.updateRequestToEntity(companyRequest, oldCompany);
        companyRepository.save(company);
        return companyMapper.entityToDto(company);
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow();

        companyRepository.delete(company);
    }
}
