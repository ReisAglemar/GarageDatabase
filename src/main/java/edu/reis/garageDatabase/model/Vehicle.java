package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter


public abstract class Vehicle {

    private Long id;
    private String brand;
    private String name;
    private String model;
    private String color;
    private int year;
    private float price;
    private NumberPiston numberPistonpistons;
    private LocalDate dateRegistration;

    public Vehicle() {
    }

    public Vehicle(String brand, String name, String model, String color, int year, float price, String numberPistons) throws ExceptionRegister {

        this.numberPistonpistons = NumberPiston.fromDescription(numberPistons);

        int actualYear = LocalDate.now().getYear();
        if (year > actualYear || year < 2000) {
            throw new ExceptionRegister("O ano do veículo não pode ser superior ao atual ou inferior a 2000");
        }
        if (price == 0.0f){
            throw new ExceptionRegister("O valor do veículo não pode ser zero!");
        }

        this.brand = brand;
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.dateRegistration = LocalDate.now();
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
