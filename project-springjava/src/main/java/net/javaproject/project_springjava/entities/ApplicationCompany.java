package net.javaproject.project_springjava.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationCompany {

    private List<CompanyPOJO> companies;
}
