package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController2 {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Render the login form view
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userAccount", new UserAccount());
        return "account"; // Render the registration form view
    }

    @PostMapping("/register")
    public String register(UserAccount userAccount, RedirectAttributes redirectAttributes) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(encodedPassword);
        userAccountRepository.save(userAccount);

        // Redirect to the login page after successful registration
        redirectAttributes.addFlashAttribute("registrationSuccess", true);
        return "redirect:/login";
    }
}
