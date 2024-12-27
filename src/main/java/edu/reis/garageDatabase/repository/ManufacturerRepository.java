package edu.reis.garageDatabase.repository;

import edu.reis.garageDatabase.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {



}
