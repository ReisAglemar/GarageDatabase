package edu.reis.garageDatabase.app;

import edu.reis.garageDatabase.model.Car;
import edu.reis.garageDatabase.model.Motorcycle;
import edu.reis.garageDatabase.model.Truck;
import edu.reis.garageDatabase.repository.ManufacturerRepository;
import edu.reis.garageDatabase.repository.VehicleRepository;
import edu.reis.garageDatabase.service.InsertDB;
import edu.reis.garageDatabase.service.SearchDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private SearchDB searchDB;

    @Autowired
    public GarageDatabaseApp(ManufacturerRepository manufacturerRepository, VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public void init() {
        logo("Bem vindo ao Garage Database!");
        mainMenu();
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

    private void mainMenu() {
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
                System.out.println("Erro: Use valores numéricos para navegar!");
            }
        }
    }

    private void insertMenu() {
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
                System.out.println("Erro: Use valores numéricos para navegar!");
            }
        }
    }

    private void searchMenu() {
        while (true) {
            String menu = """
                    
                        1- Listar Montadoras
                        2- Listar Carros
                        3- Listar Caminhões
                        4- Listar Motocicletas
                        5- Listar Todos os Veículos
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
                        searchDB.Manufacturers();
                        return;
                    case 2:
                        searchDB.listByType(Car.class);
                        return;
                    case 3:
                        searchDB.listByType(Truck.class);
                        return;
                    case 4:
                        searchDB.listByType(Motorcycle.class);
                        return;
                    case 5:
                        searchDB.allVehicle();
                        return;
                    case 99:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Use valores numéricos para navegar!");
            }
        }
    }
}
