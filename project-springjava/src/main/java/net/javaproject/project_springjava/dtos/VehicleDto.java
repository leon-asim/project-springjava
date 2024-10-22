package net.javaproject.project_springjava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaproject.project_springjava.entities.Company;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private Long id;
    private String brand;
    private String registration;
    private Company company;
}
