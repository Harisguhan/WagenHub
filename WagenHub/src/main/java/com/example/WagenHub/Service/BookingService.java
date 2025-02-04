package com.example.WagenHub.Service;

import com.example.WagenHub.Repository.BookingRepository;
import com.example.WagenHub.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Method to get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Method to get a booking by its ID
    public Optional<Booking> getBookingById(Integer bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // Method to create a new booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Method to update an existing booking
    public Booking updateBooking(Integer bookingId, Booking updatedBooking) {
        Optional<Booking> existingBooking = bookingRepository.findById(bookingId);
        if (existingBooking.isPresent()) {
            updatedBooking.setBookingID(bookingId);
            return bookingRepository.save(updatedBooking);
        }
        return null;
    }

    // Method to delete a booking
    public void deleteBooking(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    // Method to find bookings by userId
    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Method to find bookings by carId
    public List<Booking> getBookingsByCarId(Integer carId) {
        return bookingRepository.findByCarId(carId);
    }

    // Method to find bookings by booking status
    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findByBookingStatus(status);
    }
}
