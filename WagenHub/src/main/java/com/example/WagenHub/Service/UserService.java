package com.example.WagenHub.Service;

import com.example.WagenHub.models.User;
import com.example.WagenHub.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to get a user by their ID
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Method to get a user by their license
    public Optional<User> getUserByLicense(String license) {
        return userRepository.findByLicense(license);
    }

    // Method to get a user by their phone number
    public Optional<User> getUserByPhoneNo(long phoneNo) {
        return userRepository.findByPhoneNo(phoneNo);
    }

    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to update an existing user
    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            updatedUser.setUserID(userId);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    // Method to delete a user
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
