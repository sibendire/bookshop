package com.bookshop.bookshopmanagement.controller;

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

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Render the login form view
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        // Implement authentication logic using userAccountService
        boolean authenticated = userAccountService.authenticateUser(email, password);

        if (authenticated) {
            // Set user information in the session if needed
            // Redirect to a welcome or profile page upon successful login
            return "redirect:/welcome";
        } else {
            model.addAttribute("loginError", true); // Add an error attribute to display in the view
            return "login"; // Return to the login form with an error message
        }
    }
}
