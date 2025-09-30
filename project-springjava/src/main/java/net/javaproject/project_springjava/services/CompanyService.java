package net.javaproject.project_springjava.services;

import net.javaproject.project_springjava.dtos.CompanyDto;
import net.javaproject.project_springjava.entities.Company;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto getCompany(Long CompanyId);

    List<CompanyDto> getAllCompanies();
    List<CompanyDto> getAllCompaniesPage(int pageNum, int pageSize);

    CompanyDto updateCompany(Long companyId, CompanyDto companyDto);

    void deleteCompany(Long companyId);

    Company getByName(String name);
}
