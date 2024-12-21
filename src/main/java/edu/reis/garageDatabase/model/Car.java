package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Car extends Vehicle {

    private int occupants;

    public Car() {
    }

    public Car(String brand, String name, String model, String color, int year, float price, String numberPistons,
               int occupants) throws ExceptionRegister {
        super(brand, name, model, color, year, price, numberPistons);
        this.occupants = occupants;
    }

    public void details() {
        String string = super.toString()+
                """
                            Ocupantes: %d
                            Numero de pistões: %s
                            Price: R$ %.2f
                            --------------------------------
                            ID: %d
                            Data de inclusão: %s
                        
                        """.formatted(occupants, super.getNumberPistonpistons(), super.getPrice(), super.getId(), super.getDateRegistration());
        System.out.println(string);
    }
}
