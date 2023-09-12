package com.bookshop.bookshopmanagement.controller;


import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAccountController {
    private UserAccountService userAccountService;

    @GetMapping("/account")
    public String createAccount() {
        return "signUp";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute @Validated UserAccount userAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account";
        } else {
            userAccountService.save(userAccount);
            return "redirect:/login";
        }
    }
}
