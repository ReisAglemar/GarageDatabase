package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "GDB_MOTORCYCLE")


public class Motorcycle extends Vehicle {

    private int cylinderCapacity;

    public Motorcycle(String brand, String name, String model, String color, int year, float price, String numberPistons,
                      int cylinderCapacity, Manufacturer manufacturer) throws ExceptionRegister, ExceptionGemini, IOException, InterruptedException {
        super(brand, name, model, color, year, price, numberPistons, manufacturer);
        this.cylinderCapacity = cylinderCapacity;
    }

    public void details() {
        String string = super.toString() +
                """
                            Cilindradas: %d
                            Numero de pistões: %s
                            Price: R$ %.2f
                            --------------------------------
                            ID: %d
                            Data de inclusão: %s
                            Descrição: %s
                        
                        """.formatted(cylinderCapacity, super.getNumberPistons(), super.getPrice(),
                        super.getId(), super.getDateRegistration(), super.getDescription());
        System.out.println(string);
    }

}
