package edu.reis.garageDatabase.config;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import edu.reis.garageDatabase.repository.ManufacturerRepository;
import edu.reis.garageDatabase.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class GarageDatabaseApp {

    @Autowired
    private Scanner input;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private InsertDB insertDB;

    @Autowired
    public GarageDatabaseApp(ManufacturerRepository manufacturerRepository, VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public void init() throws ExceptionRegister, ExceptionGemini, IOException, InterruptedException {

        logo("Bem vindo ao Garage Database!");
        mainMenu();

//        Car car = new Car("Honda", "Civic", "LX", "Azul", 2002,
//                12500.54f, "4", 5);
//        car.details();
//        vehicleRepository.save(car);
//
//        Truck truck = new Truck("Scania", "R500", "ATV2", "Cinza",
//                2022, 250000.00f, "8", 23000);
//        truck.details();
//        vehicleRepository.save(truck);
//
//        Motorcycle motorcycle = new Motorcycle("Suzuki", "Srad", "sr1000", "Verde",
//                2023, 50000.00f, "4", 1000);
//        motorcycle.details();
//        vehicleRepository.save(motorcycle);
//
//        Manufacturer manufacturer = new Manufacturer("Honda");
//        System.out.println(manufacturer.toString());
//        manufacturerRepository.save(manufacturer);
//
//        String pause = in.nextLine();
    }

    private void logo(String mensage) {
        String logo = """
                
                      ____ ____  ____       _               \s
                     / ___|  _ \\| __ )     / \\   _ __  _ __ \s
                    | |  _| | | |  _ \\    / _ \\ | '_ \\| '_ \\\s
                    | |_| | |_| | |_) |  / ___ \\| |_) | |_) |
                     \\____|____/|____/  /_/   \\_\\ .__/| .__/\s
                                                |_|   |_|   \s
                
                        %s
                
                
                """.formatted(mensage);
        System.out.println(logo);
    }

    private void mainMenu() throws ExceptionGemini, IOException, InterruptedException {
        while (true) {
            String mainMenu = """
                    
                        1- Cadastrar
                        2- Pesquisar
                        0- Encerrar
                    
                    """;
            System.out.println(mainMenu);

            try {
                int option = Integer.parseInt(input.nextLine());
                switch (option) {
                    case 0:
                        logo("Obrigado por utilizar nosso sistema!");
                        return;
                    case 1:
                        insertMenu();
                        break;
                    case 2:
                        searchMenu();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Para navegar no menu insira o número correspondente");
            }
        }
    }

    private void insertMenu() throws ExceptionGemini, IOException, InterruptedException {
        while (true) {
            String menu = """
                    
                        1- Cadastrar Montadora
                        2- Cadastrar Carro
                        3- Cadastrar Caminhão
                        4- Cadastrar Motocicleta
                        0- Retornar ao Menu Anterior
                        99- Encerrar imediatamente
                    
                    """;
            System.out.println(menu);

            try {
                int option = Integer.parseInt(input.nextLine());
                switch (option) {
                    case 0:
                        return;
                    case 1:
                        System.out.println(this.manufacturerRepository);
                        insertDB.insertManufacturer();
                        return;
                    case 2:
                        insertDB.insertCar();
                        return;
                    case 3:
                        insertDB.insertTruck();
                        return;
                    case 4:
                        insertDB.insertMotorcyle();
                        return;
                    case 99:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Para navegar no menu insira o número correspondente");
            }
        }
    }

    private void searchMenu() {
    }

}
