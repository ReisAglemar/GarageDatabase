package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.gemini.ExceptionGemini;
import edu.reis.garageDatabase.service.Gemini;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "GDB_MANUFACTURER")

public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Motorcycle> motorcycles = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Truck> trucks = new ArrayList<>();

    @Transient
    private Gemini gemini = new Gemini();

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
