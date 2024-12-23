package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.service.Gemini;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Manufacturer {
    private Long id;
    private String name;
    private String description;
    private List<Car> cars = new ArrayList<>();
    private List<Motorcycle> motorcycles = new ArrayList<>();
    private List<Truck> trucks = new ArrayList<>();
    private Gemini gemini = new Gemini();

    public Manufacturer() {}

    public Manufacturer(String name) throws ExceptionGemini, IOException, InterruptedException {
        this.name = name;
        this.description = gemini.getInfoManufacturer(name);
    }

    @Override
    public String toString() {
        String string = """
                
                    Marca: %s
                    Descrição: %s
                """.formatted(name, description);
        return string;
    }
}
