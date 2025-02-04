package com.example.WagenHub.Repository;
import com.example.WagenHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query to find a user by their license
    Optional<User> findByLicense(String license);

    // Custom query to find a user by their phone number
    Optional<User> findByPhoneNo(long phoneNo);
}
