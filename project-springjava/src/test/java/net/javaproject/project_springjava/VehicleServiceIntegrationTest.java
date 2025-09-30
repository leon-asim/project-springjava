package net.javaproject.project_springjava;

import net.javaproject.project_springjava.entities.Company;
import net.javaproject.project_springjava.entities.Vehicle;
import net.javaproject.project_springjava.repositories.CompanyRepository;
import net.javaproject.project_springjava.repositories.VehicleRepository;
import net.javaproject.project_springjava.services.CompanyService;
import net.javaproject.project_springjava.services.VehicleService;
import net.javaproject.project_springjava.services.impls.CompanyServiceImpl;
import net.javaproject.project_springjava.services.impls.VehicleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceIntegrationTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private VehicleService vehicleService = new VehicleServiceImpl();

    @Test
    public void getVehicleTest() {
        String registration = "bt6767ag";

        when(vehicleService.getVehicleByRegistration(registration)).thenReturn(new Vehicle("vehicle1", "bt6767ag"));

        Vehicle vehicle = vehicleService.getVehicleByRegistration(registration);
        Assertions.assertTrue(vehicle.getRegistration().equals(registration));
    }

//    @Test
//    public void getVehicleByCompany() {
//        Long companyId = Long.valueOf(1);
//        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company("company1", "address1")));
//
//        when(vehicleService.getVehicleByCompany(any())).thenReturn(new)
//    }
}
