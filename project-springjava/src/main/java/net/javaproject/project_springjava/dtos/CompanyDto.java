package net.javaproject.project_springjava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaproject.project_springjava.entities.Vehicle;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private String address;
    private Set<Vehicle> vehicles;

    public CompanyDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
