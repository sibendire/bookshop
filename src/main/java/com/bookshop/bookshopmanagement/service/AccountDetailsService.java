package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Find the user account by email
        UserAccount userAccount = userAccountRepository.findByEmail(email);

        if (userAccount == null) {
            throw new UsernameNotFoundException("User not found with the email: " + email);
        }

        // Build the authorities/roles for the user (you can customize this as needed)
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Example role

        // Create a UserDetails object with user information
        return new org.springframework.security.core.userdetails.User(
                userAccount.getEmail(), // Username (email in this case)
                userAccount.getPassword(), // Password
                authorities
        );
    }
}
