package net.javaproject.project_springjava.mappers;

import net.javaproject.project_springjava.dtos.VehicleDto;
import net.javaproject.project_springjava.entities.Vehicle;

public class VehicleMapper {

    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getRegistration(), vehicle.getCompany());
    }

    public static Vehicle mapToVehicle(VehicleDto vehicleDto) {
        return new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(), vehicleDto.getRegistration(), vehicleDto.getCompany());
    }
}
