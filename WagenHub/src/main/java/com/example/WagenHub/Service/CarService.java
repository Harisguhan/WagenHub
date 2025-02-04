package com.example.WagenHub.Service;

import com.example.WagenHub.models.Car;
import com.example.WagenHub.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Get all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Get car by ID
    public Optional<Car> getCarById(int vehicleId) {
        return carRepository.findById(vehicleId);
    }

    // Save a new car
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // Update an existing car
    public Car updateCar(int vehicleId, Car car) {
        if (carRepository.existsById(vehicleId)) {
            car.setVehicleID(vehicleId);
            return carRepository.save(car);
        } else {
            return null; // Or throw an exception
        }
    }

    // Delete a car by ID
    public boolean deleteCar(int vehicleId) {
        if (carRepository.existsById(vehicleId)) {
            carRepository.deleteById(vehicleId);
            return true;
        }
        return false;
    }

    // Get car by model
    public Car getCarByModel(String model) {
        return carRepository.findByModel(model);
    }

    // Get car by plate number
    public Car getCarByPlate(Integer plate) {
        return carRepository.findByPlate(plate);
    }
}

