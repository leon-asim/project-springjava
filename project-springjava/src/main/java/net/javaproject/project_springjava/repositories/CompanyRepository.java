package net.javaproject.project_springjava.repositories;

import net.javaproject.project_springjava.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByName(String name);
}
