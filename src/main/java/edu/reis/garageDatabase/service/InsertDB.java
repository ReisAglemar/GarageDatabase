package edu.reis.garageDatabase.service;

import edu.reis.garageDatabase.model.Car;
import edu.reis.garageDatabase.model.Manufacturer;
import edu.reis.garageDatabase.model.Motorcycle;
import edu.reis.garageDatabase.model.Truck;
import edu.reis.garageDatabase.repository.ManufacturerRepository;
import edu.reis.garageDatabase.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class InsertDB {
    private ManufacturerRepository manufacturerRepository;
    private VehicleRepository vehicleRepository;
    private Scanner input;
    private Manufacturer manufacturer;

    @Autowired
    private SearchDB searchDB;

    @Autowired
    public InsertDB(ManufacturerRepository manufacturerRepository, VehicleRepository vehicleRepository, Scanner input) {
        this.manufacturerRepository = manufacturerRepository;
        this.vehicleRepository = vehicleRepository;
        this.input = input;
    }

    public void insertManufacturer() {
        System.out.print("    Insira o nome do fabricante: ");
        String name = input.nextLine();
        try {
            Manufacturer manufacturer = new Manufacturer(name);
            manufacturerRepository.save(manufacturer);

            if (searchDB.comfirmSaveManufacturer(manufacturer).isPresent()) {
                System.out.println("    \nFabricante salvo com sucesso!");
            } else {
                System.out.println("    \nFabricante não encontrado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertCar() {
        if (manufacturerlist()) {
            insert(" do carro: ");
        }
    }

    public void insertTruck() {
        if (manufacturerlist()) {
            insert(" do caminhão: ");
        }
    }

    public void insertMotorcyle() {
        if (manufacturerlist()) {
            insert(" da moto: ");
        }
    }

    private Boolean manufacturerlist() {
        List<Manufacturer> manufacturers = searchDB.listManufacturers();
        if (manufacturers.size() != 0) {
            System.out.println("    Veja as fabricantes cadastradas");
            manufacturers.forEach(System.out::println);
            System.out.println("    Escolha uma fabricante para o veículo que será cadastrado");
            manufacturer = searchDB.findManufacturerByName(input.nextLine());
            if (manufacturer != null) {
                return true;
            } else {
                System.out.println("    Fabricante não encontrada!");
            }

        } else {
            System.out.println("    Não há fabricantes cadastradas, cadastre uma fabricante");
        }
        return false;
    }

    public void insert(String vehicleType) {
        try {
            System.out.print("    Insira a marca" + vehicleType);
            String brand = input.nextLine();
            System.out.print("    Insira o nome" + vehicleType);
            String name = input.nextLine();
            System.out.print("    Insira o modelo" + vehicleType);
            String model = input.nextLine();
            System.out.print("    Insira a cor" + vehicleType);
            String color = input.nextLine();
            System.out.print("    Insira o ano" + vehicleType);
            int year = Integer.parseInt(input.nextLine());
            System.out.print("    Insira o valor" + vehicleType);
            float price = Float.parseFloat(input.nextLine());
            System.out.print("    Insira a quantidade de pistões: ");
            String numberPistons = input.nextLine();


            if (vehicleType.equals(" do carro: ")) {
                System.out.print("    Insira o número de ocupantes" + vehicleType);
                int occupants = Integer.parseInt(input.nextLine());

                Car car = new Car(brand, name, model, color, year, price, numberPistons, occupants, manufacturer);
                vehicleRepository.save(car);

                if (searchDB.comfirmSaveVehicle(car).isPresent()) {
                    System.out.println("    \nCarro salvo com sucesso!");
                } else {
                    System.out.println("    \nCarro não encontrado!");
                }
            }

            if (vehicleType.equals(" do caminhão: ")) {
                System.out.print("    Insira a capacidade de carga" + vehicleType);
                int loadCapacity = Integer.parseInt(input.nextLine());

                Truck truck = new Truck(brand, name, model, color, year, price, numberPistons, loadCapacity, manufacturer);
                vehicleRepository.save(truck);

                if (searchDB.comfirmSaveVehicle(truck).isPresent()) {
                    System.out.println("    \nCaminhão salvo com sucesso!");
                } else {
                    System.out.println("    \nCaminhão não encontrado!");
                }
            }

            if (vehicleType.equals(" da moto: ")) {
                System.out.print("    Insira as cilindradas" + vehicleType);
                int cylinderCapacity = Integer.parseInt(input.nextLine());

                Motorcycle motorcycle = new Motorcycle(brand, name, model, color, year, price, numberPistons, cylinderCapacity, manufacturer);
                vehicleRepository.save(motorcycle);

                if (searchDB.comfirmSaveVehicle(motorcycle).isPresent()) {
                    System.out.println("    \nMoto salva com sucesso!");
                } else {
                    System.out.println("    \nMoto não encontrada!");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
