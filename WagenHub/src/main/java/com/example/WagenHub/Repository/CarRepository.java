package com.example.WagenHub.Repository;

import com.example.WagenHub.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    // You can add custom queries here if needed, for example:
    Car findByModel(String model);
    Car findByPlate(Integer plate);
}

