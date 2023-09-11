package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;
    public void save(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }
}
