package net.javaproject.project_springjava.mappers;

import net.javaproject.project_springjava.dtos.CompanyDto;
import net.javaproject.project_springjava.entities.Company;

public class CompanyMapper {

    public static CompanyDto mapToCompanyDto(Company company) {
        return new CompanyDto(company.getId(), company.getName(), company.getAddress(), company.getVehicles());
    }

    public static Company mapToCompany(CompanyDto companyDto) {
        return new Company(companyDto.getId(), companyDto.getName(), companyDto.getAddress(), companyDto.getVehicles());
    }
}
