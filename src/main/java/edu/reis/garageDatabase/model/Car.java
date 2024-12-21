package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Car extends Vehicle {

    private int occupants;
    private float price;

    public Car() {
    }

    public Car(String brand, String name, String model, String color, String numberPistons, int year,
               int occupants, float price) throws ExceptionRegister {
        super(brand, name, model, color, numberPistons, year);

        if (price == 0.0f) {
            throw new ExceptionRegister("Veiculo não pode ser registrado com preço zerado!");
        }
        this.occupants = occupants;
        this.price = price;
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
                        
                        """.formatted(occupants, super.getNumberPistonpistons(), price, super.getId(), super.getDateRegistration());
        System.out.println(string);
    }
}
