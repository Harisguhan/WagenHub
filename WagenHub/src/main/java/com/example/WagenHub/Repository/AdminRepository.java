package com.example.WagenHub.Repository;

import com.example.WagenHub.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // You can add custom queries here if needed, for example:
    Admin findByUsername(String username);
}

