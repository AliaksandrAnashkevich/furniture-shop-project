package com.furniture.store.mapper;

import com.furniture.store.dto.request.CompanyRequest;
import com.furniture.store.dto.response.CompanyResponse;
import com.furniture.store.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponse entityToDto(Company company);

    Company dtoToEntity(CompanyRequest companyRequest);

    Company updateRequestToEntity(CompanyRequest companyRequest, @MappingTarget Company company);
}
