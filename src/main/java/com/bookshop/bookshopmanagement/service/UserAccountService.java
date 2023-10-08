package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    public  void saveCreatedAccount(UserAccount userAccount){

        userAccountRepository.save(userAccount);
    }

    public boolean createAccountIfNotExists(String email, String password) {
        // Your implementation here, including saving to the repository
        UserAccount existingUserAccount = userAccountRepository.findByEmail(email);
        if (existingUserAccount == null){
            UserAccount newUserAccount = new UserAccount();
            newUserAccount.setEmail(email);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = bCryptPasswordEncoder.encode(password);
            newUserAccount.setPassword(encodedPassword);

            // Save the new user account
            saveCreatedAccount(newUserAccount);

            return true; // Account created successfully
        }
        return false;
    }
}
