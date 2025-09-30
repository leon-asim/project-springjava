package net.javaproject.project_springjava;

import net.javaproject.project_springjava.entities.ApplicationCompany;
import net.javaproject.project_springjava.entities.CompanyPOJO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = YmlListTest.TestConfig.class,
        initializers = ConfigDataApplicationContextInitializer.class
)
public class YmlListTest {

    @Autowired
    private ApplicationCompany applicationCompanies;

    @Configuration
    @EnableConfigurationProperties(ApplicationCompany.class)
    static class TestConfig {
        // This tells Spring to bind "application.*" into an ApplicationCompany bean
    }

    @Test
    public void whenYamlList_thenLoadSimpleList() {
        assertThat(applicationCompanies.getCompanies().get(0).getName()).isEqualTo("company1");
        assertThat(applicationCompanies.getCompanies().get(1).getClass()).isEqualTo(CompanyPOJO.class);
        assertThat(applicationCompanies.getCompanies().size()).isEqualTo(2);
    }
}
