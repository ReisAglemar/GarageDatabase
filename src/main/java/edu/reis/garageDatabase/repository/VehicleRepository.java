package edu.reis.garageDatabase.repository;

import edu.reis.garageDatabase.model.Car;
import edu.reis.garageDatabase.model.Motorcycle;
import edu.reis.garageDatabase.model.Truck;
import edu.reis.garageDatabase.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE TYPE(v) = Car")
    List<Car> onlyCars();

    @Query("SELECT v FROM Vehicle v WHERE TYPE(v) = Truck ")
    List<Truck> onlyTrucks();

    @Query("SELECT v FROM Vehicle v WHERE TYPE(v) = Motorcycle ")
    List<Motorcycle> onlyMotorcycles();
}
