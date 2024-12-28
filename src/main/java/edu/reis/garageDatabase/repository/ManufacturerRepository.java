package edu.reis.garageDatabase.repository;

import edu.reis.garageDatabase.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {


    Manufacturer findByNameEqualsIgnoreCase(String name);
}
