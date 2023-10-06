package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.repository.UserAccountRepository;
import com.bookshop.bookshopmanagement.service.UserAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController2 {
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserAccountRepository userAccountRepository;


    public LoginController2(UserAccountService userAccountService, UserAccountRepository userAccountRepository) {
        this.userAccountService = userAccountService;
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Render the login form view
    }

    @GetMapping("/signUp")
    public String showRegistrationForm(Model model) {
        model.addAttribute("UserAccount",new UserAccount());
        return "account"; // Render the registration form view
    }
    @PostMapping("/saveUser")
    public String registration(UserAccount userAccount){
        userAccountRepository.save(userAccount);

        return "redirect:/login";
    }

    @PostMapping("/signUp")
    public String register(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        // Implement account creation logic using userAccountService
        boolean accountCreated = userAccountService.createAccountIfNotExists(email, password);

        if (accountCreated) {
            // Account was created successfully, you can choose to automatically log in the user
            // Set user information in the session if needed
            // Redirect to a welcome or profile page upon successful registration
            return "redirect:/login";
        } else {
            model.addAttribute("registrationError", true); // Add an error attribute to display in the view
            return "account"; // Return to the registration form with an error message
        }
    }
}
