package com.example.WagenHub.Service;

import com.example.WagenHub.models.Admin;
import com.example.WagenHub.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get an admin by ID
    public Optional<Admin> getAdminById(int adminId) {
        return adminRepository.findById(adminId);
    }

    // Save a new admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update an existing admin
    public Admin updateAdmin(int adminId, Admin admin) {
        if (adminRepository.existsById(adminId)) {
            admin.setAdminId(adminId);
            return adminRepository.save(admin);
        } else {
            return null; // Or throw an exception
        }
    }

    // Delete an admin by ID
    public boolean deleteAdmin(int adminId) {
        if (adminRepository.existsById(adminId)) {
            adminRepository.deleteById(adminId);
            return true;
        }
        return false;
    }

    // Get admin by username (optional)
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
