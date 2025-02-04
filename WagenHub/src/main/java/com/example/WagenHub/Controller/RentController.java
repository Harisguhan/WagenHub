package com.example.WagenHub.Controller;
import com.example.WagenHub.Service.RentService;
import com.example.WagenHub.models.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    // Get all rents
    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.getAllRents();
    }

    // Get a specific rent by ID
    @GetMapping("/{rentalId}")
    public ResponseEntity<Rent> getRentById(@PathVariable Integer rentalId) {
        Optional<Rent> rent = rentService.getRentById(rentalId);
        return rent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get rents by pay method
    @GetMapping("/pay-method/{payMethod}")
    public List<Rent> getRentsByPayMethod(@PathVariable String payMethod) {
        return rentService.getRentsByPayMethod(payMethod);
    }

    // Get rents by pay date
    @GetMapping("/pay-date/{payDate}")
    public List<Rent> getRentsByPayDate(@PathVariable String payDate) {
        LocalDate parsedDate = LocalDate.parse(payDate);
        return rentService.getRentsByPayDate(parsedDate);
    }

    // Create a new rent
    @PostMapping
    public ResponseEntity<Rent> createRent(@RequestBody Rent rent) {
        Rent createdRent = rentService.createRent(rent);
        return ResponseEntity.ok(createdRent);
    }

    // Update an existing rent
    @PutMapping("/{rentalId}")
    public ResponseEntity<Rent> updateRent(@PathVariable Integer rentalId, @RequestBody Rent updatedRent) {
        Rent rent = rentService.updateRent(rentalId, updatedRent);
        return rent != null ? ResponseEntity.ok(rent) : ResponseEntity.notFound().build();
    }

    // Delete a rent
    @DeleteMapping("/{rentalId}")
    public ResponseEntity<Void> deleteRent(@PathVariable Integer rentalId) {
        rentService.deleteRent(rentalId);
        return ResponseEntity.noContent().build();
    }
}
