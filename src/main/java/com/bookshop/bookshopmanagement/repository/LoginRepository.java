package com.bookshop.bookshopmanagement.repository;

//import com.bookshop.bookshopmanagement.entity.Login;
import com.bookshop.bookshopmanagement.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserAccount, Long> {

}
