package net.javaproject.project_springjava.services.impls;

import lombok.AllArgsConstructor;
import net.javaproject.project_springjava.dtos.VehicleDto;
import net.javaproject.project_springjava.entities.Company;
import net.javaproject.project_springjava.entities.Vehicle;
import net.javaproject.project_springjava.exceptions.ObjectNotFoundException;
import net.javaproject.project_springjava.mappers.CompanyMapper;
import net.javaproject.project_springjava.mappers.VehicleMapper;
import net.javaproject.project_springjava.repositories.CompanyRepository;
import net.javaproject.project_springjava.repositories.VehicleRepository;
import net.javaproject.project_springjava.services.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private CompanyRepository companyRepository;
    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDto(savedVehicle);
    }

    @Override
    public VehicleDto getVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ObjectNotFoundException("Vehicle with id: " + vehicleId + " doesn't exist"));
        return VehicleMapper.mapToVehicleDto(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(VehicleMapper::mapToVehicleDto).collect(Collectors.toList());
    }

    @Override
    public VehicleDto updateVehicle(Long vehicleId, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ObjectNotFoundException("Vehicle with id: " + vehicleId + " doesn't exist"));

        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setRegistration(vehicleDto.getRegistration());

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return VehicleMapper.mapToVehicleDto(savedVehicle);
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ObjectNotFoundException("Vehicle with id: " + vehicleId + " doesn't exist"));
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public VehicleDto assignCompanyToVehicle(Long vehicleId, Long companyId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ObjectNotFoundException("Vehicle with id: " + vehicleId + " doesn't exist"));

        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ObjectNotFoundException("Company with id: " + companyId + " doesn't exist"));

        vehicle.assignToCompany(company);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDto(savedVehicle);
    }
}
