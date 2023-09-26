package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.LoginRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    public boolean login(UserAccount userAccount) {
        return loginRepository.existsById(userAccount.getId());
    }

    public void registerUser(UserAccount userAccount) {
        // Validate user input
        if (isValidUser(userAccount)) {
            // Hash the password
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));

            // Save the user account
            loginRepository.save(userAccount);
        }

    }

    private boolean isValidUser(UserAccount userAccount) {
        return false;
    }

}