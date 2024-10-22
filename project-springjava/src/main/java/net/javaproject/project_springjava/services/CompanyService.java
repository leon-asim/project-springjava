package net.javaproject.project_springjava.services;

import net.javaproject.project_springjava.dtos.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto getCompany(Long CompanyId);

    List<CompanyDto> getAllCompanies();

    CompanyDto updateCompany(Long companyId, CompanyDto companyDto);

    void deleteCompany(Long companyId);
}
