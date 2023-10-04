package com.bookshop.bookshopmanagement.service;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    void saveUser(UserAccount userAccount);
}
