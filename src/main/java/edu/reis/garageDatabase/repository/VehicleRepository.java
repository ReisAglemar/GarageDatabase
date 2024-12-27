package edu.reis.garageDatabase.repository;

import edu.reis.garageDatabase.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
