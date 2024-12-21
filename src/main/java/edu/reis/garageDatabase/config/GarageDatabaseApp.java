package edu.reis.garageDatabase.config;


import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import edu.reis.garageDatabase.model.Car;

public class GarageDatabaseApp {

    public void init() throws ExceptionRegister {
        System.out.println("Initializing Garage Database");

        Car car = new Car("Honda", "Civic", "LX", "Azul Nevada", "4", 2002, 5, 12500.56f);
        car.details();

    }
}
