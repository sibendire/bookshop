package com.bookshop.bookshopmanagement.controller;


import com.bookshop.bookshopmanagement.entity.UserAccount;
import com.bookshop.bookshopmanagement.service.UserAccountService;
import jakarta.validation.Valid;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

    @Controller
    public class AuthController {

        private UserAccountService userAccountService;

        public AuthController(UserAccountService userAccountService) {
            this.userAccountService = userAccountService;
        }

        // handler method to handle home page request
        @GetMapping("/index")
        public String home(){
            return "index";
        }

        // handler method to handle login request
        @GetMapping("/login")
        public String login(){
            return "login";
        }

        // handler method to handle user registration form request
        @GetMapping("/register")
        public String showRegistrationForm(Model model){
            // create model object to store form data
            UserAccount user = new UserAccount();
            model.addAttribute("user", user);
            return "register";
        }

        // handler method to handle user registration form submit request
        @PostMapping("/register/save")
        public String registration(@Valid @ModelAttribute("user") UserAccount userAccount,
                                   BindingResult result,
                                   Model model){
            User existingUser = userAccount.findUserByEmail(userAccount.getEmail());

            if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
                result.rejectValue("email", null,
                        "There is already an account registered with the same email");
            }

            if(result.hasErrors()){
                model.addAttribute("user", userAccount);
                return "/register";
            }

            userAccountService.saveUser(userAccount);
            return "redirect:/register?success";
        }

        // handler method to handle list of users
        @GetMapping("/users")
        public String users(Model model){
            List<UserAccount> users = userAccountService.findAllUsers();
            model.addAttribute("users", users);
            return "users";
        }
    }

