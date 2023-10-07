package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.AccountDetails;
import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByEmail(email);
        if (userAccount == null){
            throw new UsernameNotFoundException("User not found with the email");
        }
        return new AccountDetails(userAccount);
    }
}
