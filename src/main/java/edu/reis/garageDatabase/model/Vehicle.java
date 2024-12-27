package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import edu.reis.garageDatabase.service.Gemini;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "GDB_VEHICLE")

public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String name;
    private String model;
    private String color;
    private int year;
    private float price;
    private NumberPiston numberPistons;
    private LocalDate dateRegistration;
    private String description;

    @Transient
    private Gemini gemini = new Gemini();


    public Vehicle() {
    }

    public Vehicle(String brand, String name, String model, String color, int year, float price, String numberPistons)
            throws ExceptionRegister, ExceptionGemini, IOException, InterruptedException {

        this.numberPistons = NumberPiston.fromDescription(numberPistons);

        int actualYear = LocalDate.now().getYear();
        if (year > actualYear || year < 2000) {
            throw new ExceptionRegister("O ano do veículo não pode ser superior ao atual ou inferior a 2000");
        }
        if (price == 0.0f) {
            throw new ExceptionRegister("O valor do veículo não pode ser zero!");
        }

        this.brand = brand;
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.dateRegistration = LocalDate.now();
        setDescription(gemini.getInfoVehicle(brand, name, model, year));
    }

    @Override
    public String toString() {
        String string = """
                
                    Marca: %s
                    Nome: %s
                    Modelo: %s
                    Ano: %d
                    Cor: %s
                """.formatted(brand, name, model, year, color);
        return string;
    }
}
