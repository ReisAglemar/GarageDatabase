package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter

public class Car extends Vehicle {

    private int occupants;

    public Car() {
    }

    public Car(String brand, String name, String model, String color, int year, float price, String numberPistons,
               int occupants) throws ExceptionRegister, ExceptionGemini, IOException, InterruptedException {
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
                            Descrição: %s
                        
                        """.formatted(occupants, super.getNumberPistonpistons(), super.getPrice(), super.getId(),
                        super.getDateRegistration(), super.getDescription());
        System.out.println(string);
    }
}
