package com.bookshop.bookshopmanagement.repository;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    @Query("SELECT u FROM UserAccount u WHERE u.email=?1")
    UserAccount findByEmail(String email);
}
