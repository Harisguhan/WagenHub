package com.example.WagenHub.models;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalID;

    @Column(name = "pay_method", nullable = false)
    private String payMethod;

    @Column(name = "pay_date", nullable = false)
    private LocalDate payDate;

    @Column(name = "damage_compensation", nullable = false)
    private Double damageCompensation;

    // Getters and Setters
    public Integer getRentalID() {
        return rentalID;
    }

    public void setRentalID(Integer rentalID) {
        this.rentalID = rentalID;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public Double getDamageCompensation() {
        return damageCompensation;
    }

    public void setDamageCompensation(Double damageCompensation) {
        this.damageCompensation = damageCompensation;
    }
}
