package net.javaproject.project_springjava.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.javaproject.project_springjava.dtos.VehicleDto;
import net.javaproject.project_springjava.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    @Operation(summary  = "Create vehicle",
            description = "This method creates a new vehicle")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto savedVehicle = vehicleService.createVehicle(vehicleDto);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @Operation(summary  = "Get vehicle",
            description = "This method shows a vehicle by it's id")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable("id") Long vehicleId) {
        VehicleDto vehicleDto = vehicleService.getVehicle(vehicleId);
        return ResponseEntity.ok(vehicleDto);
    }

    @GetMapping
    @Operation(summary  = "Get all vehicles",
            description = "This method shows all the created vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicleDtos = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicleDtos);
    }

    @PutMapping("{id}")
    @Operation(summary  = "Update vehicle",
            description = "This method updates information about a vehicle")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") Long vehicleId, @RequestBody VehicleDto vehicleDto) {
        VehicleDto savedVehicle = vehicleService.updateVehicle(vehicleId, vehicleDto);
        return ResponseEntity.ok(savedVehicle);
    }

    @DeleteMapping("{id}")
    @Operation(summary  = "Delete vehicle",
            description = "This method deletes a vehicle by it's id")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle has been deleted");
    }

    @PutMapping("{id1}/company/{id2}")
    @Operation(summary  = "Assign company to the vehicle",
            description = "This method assign a company to a vehicle")
    public ResponseEntity<VehicleDto> assignCompanyToVehicle(@PathVariable("id1") Long vehicleId,@PathVariable("id2") Long companyId) {
        VehicleDto savedVehicle = vehicleService.assignCompanyToVehicle(vehicleId, companyId);
        return ResponseEntity.ok(savedVehicle);
    }

}
