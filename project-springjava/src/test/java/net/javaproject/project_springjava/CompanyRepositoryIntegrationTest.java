package net.javaproject.project_springjava;

import net.javaproject.project_springjava.entities.Company;
import net.javaproject.project_springjava.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CompanyRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CompanyRepository companyRepository;


    @Test
    public void whenFindByName_returnCompany() {
        Company company = new Company("company10", "address10");
        testEntityManager.persist(company);
        testEntityManager.flush();

        Company found = companyRepository.findCompanyByName(company.getName());

        assertThat(found.getName()).isEqualTo(company.getName());
    }
}
