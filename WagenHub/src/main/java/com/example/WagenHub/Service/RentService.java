package com.example.WagenHub.Service;
import com.example.WagenHub.models.Rent;
import com.example.WagenHub.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    // Method to get all rents
    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    // Method to get a rent by its ID
    public Optional<Rent> getRentById(Integer rentalId) {
        return rentRepository.findById(rentalId);
    }

    // Method to create a new rent
    public Rent createRent(Rent rent) {
        return rentRepository.save(rent);
    }

    // Method to update an existing rent
    public Rent updateRent(Integer rentalId, Rent updatedRent) {
        Optional<Rent> existingRent = rentRepository.findById(rentalId);
        if (existingRent.isPresent()) {
            updatedRent.setRentalID(rentalId);
            return rentRepository.save(updatedRent);
        }
        return null;
    }

    // Method to delete a rent
    public void deleteRent(Integer rentalId) {
        rentRepository.deleteById(rentalId);
    }

    // Method to find rents by pay method
    public List<Rent> getRentsByPayMethod(String payMethod) {
        return rentRepository.findByPayMethod(payMethod);
    }

    // Method to find rents by pay date
    public List<Rent> getRentsByPayDate(LocalDate payDate) {
        return rentRepository.findByPayDate(payDate);
    }
}
