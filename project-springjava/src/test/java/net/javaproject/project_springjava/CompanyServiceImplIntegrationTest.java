package net.javaproject.project_springjava;

import net.javaproject.project_springjava.entities.Company;
import net.javaproject.project_springjava.entities.Vehicle;
import net.javaproject.project_springjava.repositories.CompanyRepository;
import net.javaproject.project_springjava.repositories.VehicleRepository;
import net.javaproject.project_springjava.services.CompanyService;
import net.javaproject.project_springjava.services.VehicleService;
import net.javaproject.project_springjava.services.impls.CompanyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
public class CompanyServiceImplIntegrationTest {

    @TestConfiguration
    static class CompanyServiceImplTestContextConfiguration {

        @Bean
        public CompanyService companyService() {
            return new CompanyServiceImpl();
        }
    }



    @BeforeEach
    public void setUp() {
        Company company = new Company("company10", "address10");

        Mockito.when(companyRepository.findCompanyByName(company.getName()))
                .thenReturn(company);
    }

    @Autowired
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    public void whenValidName_thenCompanyWillBeReturned() {
        String name = "company10";
        Company company = companyService.getByName(name);

        assertThat(company.getName()).isEqualTo(name);
    }
}
