package net.javaproject.project_springjava.services.impls;

import lombok.AllArgsConstructor;
import net.javaproject.project_springjava.dtos.CompanyDto;
import net.javaproject.project_springjava.entities.Company;
import net.javaproject.project_springjava.exceptions.ObjectNotFoundException;
import net.javaproject.project_springjava.mappers.CompanyMapper;
import net.javaproject.project_springjava.repositories.CompanyRepository;
import net.javaproject.project_springjava.repositories.VehicleRepository;
import net.javaproject.project_springjava.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = CompanyMapper.mapToCompany(companyDto);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public CompanyDto getCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ObjectNotFoundException("Company with id: " + companyId + " doesn't exist"));
        return CompanyMapper.mapToCompanyDto(company);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyMapper::mapToCompanyDto).collect(Collectors.toList());
    }

    @Override
    public CompanyDto updateCompany(Long companyId, CompanyDto companyDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ObjectNotFoundException("Company with id: " + companyId + " doesn't exist"));

        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());

        Company savedCompany = companyRepository.save(company);

        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ObjectNotFoundException("Company with id: " + companyId + " doesn't exist"));
        companyRepository.deleteById(companyId);
    }
}
