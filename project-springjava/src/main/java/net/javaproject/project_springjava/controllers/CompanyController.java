package net.javaproject.project_springjava.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.javaproject.project_springjava.dtos.CompanyDto;
import net.javaproject.project_springjava.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @PostMapping
    @Operation(summary  = "Create company",
            description = "This method creates a new company")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto savedCompany = companyService.createCompany(companyDto);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @Operation(summary  = "Get company",
            description = "This method shows a company by it's id")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable("id") Long companyId) {
        CompanyDto companyDto = companyService.getCompany(companyId);
        return ResponseEntity.ok(companyDto);
    }

    @GetMapping
    @Operation(summary  = "Get all companies",
            description = "This method shows all companies")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companyDtos = companyService.getAllCompanies();
        return ResponseEntity.ok(companyDtos);
    }

    @PutMapping("{id}")
    @Operation(summary  = "Update company",
            description = "This method updates a company by it's id")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable("id") Long companyId, @RequestBody CompanyDto companyDto) {
        CompanyDto savedCompany = companyService.updateCompany(companyId, companyDto);
        return ResponseEntity.ok(savedCompany);
    }

    @DeleteMapping("{id}")
    @Operation(summary  = "Delete company",
            description = "This method deletes a company by it's id")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.ok("Company has been deleted");
    }
}
