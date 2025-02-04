package com.example.WagenHub.Controller;

import com.example.WagenHub.models.Car;
import com.example.WagenHub.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Get all cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get car by ID
    @GetMapping("/{vehicleId}")
    public ResponseEntity<Car> getCarById(@PathVariable int vehicleId) {
        Optional<Car> car = carService.getCarById(vehicleId);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Save a new car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    // Update an existing car
    @PutMapping("/{vehicleId}")
    public ResponseEntity<Car> updateCar(@PathVariable int vehicleId, @RequestBody Car car) {
        Car updatedCar = carService.updateCar(vehicleId, car);
        return updatedCar != null ? ResponseEntity.ok(updatedCar) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a car by ID
    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteCar(@PathVariable int vehicleId) {
        return carService.deleteCar(vehicleId) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Get car by model
    @GetMapping("/model/{model}")
    public ResponseEntity<Car> getCarByModel(@PathVariable String model) {
        Car car = carService.getCarByModel(model);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Get car by plate number
    @GetMapping("/plate/{plate}")
    public ResponseEntity<Car> getCarByPlate(@PathVariable Integer plate) {
        Car car = carService.getCarByPlate(plate);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

