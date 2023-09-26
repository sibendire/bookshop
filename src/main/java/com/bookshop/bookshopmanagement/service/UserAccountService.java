package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.LoginRepository;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;


    @Autowired
    private LoginRepository loginRepository;

    public void saveUserAccount(UserAccount userAccount) {
        loginRepository.save(userAccount);
    }


    // Add validation logic here...

    private boolean isValidUser(UserAccount userAccount) {
        // Implement user input validation logic (e.g., password requirements)
        return true; // Return true if the user is valid, false otherwise
    }



    public boolean authenticateUser(String email, String password) {
        return true;
    }

    public boolean createAccountIfNotExists(String email, String password) {
        return true;
    }

    public List<UserAccount> findAllUsers() {
    }
}
