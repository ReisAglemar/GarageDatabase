package edu.reis.garageDatabase.service;

import edu.reis.garageDatabase.model.Manufacturer;
import edu.reis.garageDatabase.model.Vehicle;
import edu.reis.garageDatabase.repository.ManufacturerRepository;
import edu.reis.garageDatabase.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class SearchDB {
    private ManufacturerRepository manufacturerRepository;
    private VehicleRepository vehicleRepository;
    private Scanner input;

    @Autowired
    public SearchDB(ManufacturerRepository manufacturerRepository, VehicleRepository vehicleRepository, Scanner input) {
        this.manufacturerRepository = manufacturerRepository;
        this.vehicleRepository = vehicleRepository;
        this.input = input;
    }

    public Optional<Manufacturer> comfirmSaveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.findById(manufacturer.getId());
    }

    public List<Manufacturer> listManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer findManufacturerByName(String name) {
        return manufacturerRepository.findByNameEqualsIgnoreCase(name);
    }

    public Optional<Vehicle> comfirmSaveVehicle(Vehicle vehicle) {
        return vehicleRepository.findById(vehicle.getId());
    }

    public void Manufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        manufacturers.forEach(System.out::println);
    }

    public void allVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles.forEach(System.out::println);
    }

    public void listByType(Class<? extends Vehicle> classType) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles.stream()
                .filter(classType::isInstance)
                .map(classType::cast)
                .forEach(System.out::println);
    }
}
