package net.javaproject.project_springjava.repositories;

import net.javaproject.project_springjava.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
