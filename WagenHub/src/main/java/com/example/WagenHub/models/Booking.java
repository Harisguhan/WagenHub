package com.example.WagenHub.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingID;

    @Column(name = "car_id", nullable = false)
    private Integer carId;  // Link to Car entity

    @Column(name = "user_id", nullable = false)
    private Integer userId; // Link to User entity

    @Column(name = "reserve_date", nullable = false)
    private LocalDate reserveDate;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "days", nullable = false)
    private Integer days; // Changed from Double to Integer

    @Column(name = "booking_status", nullable = false, length = 50)
    private String bookingStatus;

    // Constructors
    public Booking() {}

    public Booking(Integer carId, Integer userId, LocalDate reserveDate, LocalDate pickupDate, Integer days, String bookingStatus) {
        this.carId = carId;
        this.userId = userId;
        this.reserveDate = reserveDate;
        this.pickupDate = pickupDate;
        this.days = days;
        this.bookingStatus = bookingStatus;
    }

    // Getters and Setters
    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Integer getStartDate() {
        return 0;
    }

    public Object getEndDate() {
        return null;
    }

    public void setEndDate(Object endDate) {
    }

    public Object getTotalPrice() {
        return null;
    }
}
