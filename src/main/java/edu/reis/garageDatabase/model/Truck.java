package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
@Entity
@Table(name = "GDB_TRUCK")
public class Truck extends Vehicle {

    @ManyToOne
    private Manufacturer manufacturer;

    private int loadCapacity;

    public Truck(){}

    public Truck(String brand, String name, String model, String color, int year, float price, String numberPistons,
                 int loadCapacity) throws ExceptionRegister, ExceptionGemini, IOException, InterruptedException {
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
                        
                        """.formatted(loadCapacity, super.getNumberPistons(), super.getPrice(),
                        super.getId(), super.getDateRegistration(), super.getDescription());
        System.out.println(string);
    }
}
