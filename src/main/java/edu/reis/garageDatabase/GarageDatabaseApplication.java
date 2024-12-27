package edu.reis.garageDatabase;

import edu.reis.garageDatabase.config.GarageDatabaseApp;
import edu.reis.garageDatabase.repository.ManufacturerRepository;
import edu.reis.garageDatabase.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GarageDatabaseApplication implements CommandLineRunner {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(GarageDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GarageDatabaseApp app = new GarageDatabaseApp(manufacturerRepository, vehicleRepository);
        app.init();
    }
}
