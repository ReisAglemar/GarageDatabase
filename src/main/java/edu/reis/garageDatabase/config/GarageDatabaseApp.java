package edu.reis.garageDatabase.config;


import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import edu.reis.garageDatabase.model.Car;
import edu.reis.garageDatabase.model.Motorcycle;
import edu.reis.garageDatabase.model.Truck;

public class GarageDatabaseApp {

    public void init() throws ExceptionRegister {
        System.out.println("Initializing Garage Database");

        Car car = new Car("Honda", "Civic", "LX", "Azul", 2002,
                12500.54f, "4", 5);
        car.details();

        Truck truck =new Truck("Scania", "R500", "ATV2", "Cinza",
                2022, 250000.00f, "8", 23000);
        truck.details();

        Motorcycle motorcycle = new Motorcycle("Suzuki", "Srad", "sr1000", "Verde",
                2023, 50000.00f, "4", 1000);
        motorcycle.details();
    }
}
