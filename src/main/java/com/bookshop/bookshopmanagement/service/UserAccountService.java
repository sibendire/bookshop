package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public boolean createAccountIfNotExists(String email, String password) {
        // Your implementation here, including saving to the repository
        return false;
    }
}
