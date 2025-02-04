package com.example.WagenHub.Repository;
import com.example.WagenHub.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    // Custom query to find rents by payment method
    List<Rent> findByPayMethod(String payMethod);

    // Custom query to find rents by pay date
    List<Rent> findByPayDate(LocalDate payDate);
}
