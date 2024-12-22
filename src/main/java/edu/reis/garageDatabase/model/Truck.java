package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Truck extends Vehicle {

    private int loadCapacity;

    public Truck(){}

    public Truck(String brand, String name, String model, String color, int year, float price, String numberPistons,
                 int loadCapacity) throws ExceptionRegister {
        super(brand, name, model, color, year, price, numberPistons);
        this.loadCapacity = loadCapacity;
    }

    public void details() {
        String string = super.toString()+
                """
                            Capacidade de carga : %d kg
                            Numero de pistões: %s
                            Price: R$ %.2f
                            --------------------------------
                            ID: %d
                            Data de inclusão: %s
                            Descrição: %s
                        
                        """.formatted(loadCapacity, super.getNumberPistonpistons(), super.getPrice(),
                        super.getId(), super.getDateRegistration(), super.getDescription());
        System.out.println(string);
    }
}
