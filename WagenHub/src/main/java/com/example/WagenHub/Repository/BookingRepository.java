package com.example.WagenHub.Repository;

import com.example.WagenHub.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // Custom query to find bookings by userId
    List<Booking> findByUserId(Integer userId);

    // Custom query to find bookings by carId
    List<Booking> findByCarId(Integer carId);

    // Custom query to find bookings with a specific status
    List<Booking> findByBookingStatus(String bookingStatus);
}



