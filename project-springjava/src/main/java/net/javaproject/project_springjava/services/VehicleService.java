package net.javaproject.project_springjava.services;

import net.javaproject.project_springjava.dtos.VehicleDto;
import net.javaproject.project_springjava.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto getVehicle(Long vehicleId);

    List<VehicleDto> getAllVehicles();

    VehicleDto updateVehicle(Long vehicleId, VehicleDto vehicleDto);

    void deleteVehicle(Long vehicleId);

    VehicleDto assignCompanyToVehicle(Long vehicleId, Long companyId);

    Vehicle getVehicleByRegistration(String registration);

    Vehicle getVehicleByCompany(Long companyId);
}
