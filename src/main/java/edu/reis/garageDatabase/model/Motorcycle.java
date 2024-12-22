package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;

public class Motorcycle extends Vehicle {
    private int cylinderCapacity;

    public Motorcycle() {}

    public Motorcycle(String brand, String name, String model, String color, int year, float price, String numberPistons,
                      int cylinderCapacity) throws ExceptionRegister {
        super(brand, name, model, color, year, price, numberPistons);
        this.cylinderCapacity = cylinderCapacity;
    }

    public void details() {
        String string = super.toString()+
                """
                            Cilindradas: %d
                            Numero de pistões: %s
                            Price: R$ %.2f
                            --------------------------------
                            ID: %d
                            Data de inclusão: %s
                            Descrição: %s
                        
                        """.formatted(cylinderCapacity, super.getNumberPistonpistons(), super.getPrice(),
                        super.getId(), super.getDateRegistration(), super.getDescription());
        System.out.println(string);
    }

}
